package com.restAPI.controllers;

import com.restAPI.wrapper.CombineData;
import com.restAPI.wrapper.StudentData;

import java.sql.*;
import java.util.ArrayList;

public class StudentJoinController {


    public static ArrayList<StudentData> getAllStudents(){
        ArrayList<StudentData> result = new ArrayList<>();

        String SQL_SELECT = "select * from student;";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer sId = resultSet.getInt("s_id");
                String sName = resultSet.getString("s_name");

                StudentData obj = new StudentData();
                obj.setS_id(sId);
                obj.setS_name(sName);

                result.add(obj);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<CombineData> getJoinQueryResult(){
        ArrayList<CombineData> result = new ArrayList<>();

        String SQL_JOIN_QUERY = "select s_name, score, status, address_city, email_id, accomplishments from student s inner join marks m on s.s_id = m.s_id inner join details d on d.school_id = m.school_id;";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_JOIN_QUERY);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String sName = resultSet.getString("s_name");
                Integer score = resultSet.getInt("score");
                String status = resultSet.getString("status");
                String addressCity = resultSet.getString("address_city");
                String emailId = resultSet.getString("email_id");
                String accomplishment = resultSet.getString("accomplishments");

                CombineData obj = new CombineData();
                obj.setS_name(sName);
                obj.setScore(score);
                obj.setStatus(status);
                obj.setAddress_city(addressCity);
                obj.setEmail_ID(emailId);
                obj.setAccomplishment(accomplishment);

                result.add(obj);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

}
