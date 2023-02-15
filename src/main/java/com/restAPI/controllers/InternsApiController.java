package com.restAPI.controllers;

import com.restAPI.wrapper.InternData;
import com.restAPI.wrapper.LeadData;

import java.sql.*;
import java.util.ArrayList;

public class InternsApiController {

    public static ArrayList<InternData> getIntersData(){
        ArrayList<InternData> result = new ArrayList();

        String selctInterns = "SELECT * FROM componydb.interns_details;";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
            PreparedStatement preparedStatement = conn.prepareStatement(selctInterns);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                String education = resultSet.getString("education");


                InternData obj = new InternData();
                obj.setId(id);
                obj.setFirstName(firstName);
                obj.setLastName(lastName);
                obj.setEmail(email);
                obj.setPassword(password);
                obj.setDob(dob);
                obj.setEducation(education);
                result.add(obj);
            }

        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }

        return result;
    }
}
