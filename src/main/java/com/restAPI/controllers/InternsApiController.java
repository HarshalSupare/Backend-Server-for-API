package com.restAPI.controllers;

import com.restAPI.wrapper.InternData;

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
                obj.setGender(gender);
                obj.setDob(dob);
                obj.setEducation(education);
                result.add(obj);
            }

        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }

        return result;
    }

    //Insert a data to database
    public static Integer postInternsData(InternData recieveInternsData){
        String insertData = "INSERT INTO interns_details (first_name, last_name, email, password, gender, dob, education) VALUE  ('%s','%s','%s','%s','%s','%s','%s')";
        insertData = String.format(insertData, recieveInternsData.getFirstName(), recieveInternsData.getLastName(), recieveInternsData.getEmail(), recieveInternsData.getPassword(), recieveInternsData.getGender(),recieveInternsData.getDob(), recieveInternsData.getEducation());

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(insertData)) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recieveInternsData.getId();
    }

    public static ArrayList<InternData> findIntern(Integer recieveId){
        ArrayList<InternData> result = new ArrayList();

        String findQuery = "SELECT * FROM componydb.interns_details WHERE id = %d;";
        findQuery = String.format(findQuery, recieveId);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(findQuery)) {

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
                obj.setGender(gender);
                obj.setDob(dob);
                obj.setEducation(education);
                result.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static Integer updateInternsData(Integer recieveId, InternData recieveData){
        String updateQuery = "UPDATE interns_details SET first_name= '%s', last_name= '%s', email='%s', password = '%s', gender='%s', dob='%s', education = '%s' WHERE id = %d;";
        updateQuery =  String.format(updateQuery, recieveData.getFirstName(), recieveData.getLastName(), recieveData.getEmail(), recieveData.getPassword(), recieveData.getGender(), recieveData.getDob(), recieveData.getEducation(), recieveId);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recieveId;

    }
}
