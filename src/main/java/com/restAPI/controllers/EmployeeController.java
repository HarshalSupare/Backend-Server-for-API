package com.restAPI.controllers;

import com.restAPI.Services.EmployeeData;
import com.restAPI.exception.InvalidIdException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController {
  static ArrayList<EmployeeData> result = new ArrayList();
  static String SQL_SELECT = "select * from employee_details;";


  public static ArrayList<EmployeeData> getEmployee() {
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
      PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);


      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");
        String gender = resultSet.getString("gender");
        Date date = resultSet.getDate("dob");


        EmployeeData obj = new EmployeeData();
        obj.setId(id);
        obj.setName(name);
        obj.setAge(age);
        obj.setGender(gender);
        obj.setDob(date);
        result.add(obj);
      }

    } catch (SQLException var9) {
      throw new RuntimeException(var9);
    }

    return result;
  }

  public static Integer createRecord(EmployeeData recieveData) {
    String SQL_INSERT = "insert into employee_details(id, name, age, gender,dob) value(%d, '%s', %d, '%s', '%s');";
    SQL_INSERT = String.format(SQL_INSERT, recieveData.getId(), recieveData.getName(), recieveData.getAge(), recieveData.getGender(), recieveData.getDob());

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return recieveData.getId();
  }

  public static String deleteRecord(Integer employeeId){

    String SQL_DELETE = "delete from employee_details where id=%d;";
    SQL_DELETE = String.format(SQL_DELETE, employeeId);

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

        preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return "Data deleted Successfully";
  }

  public static String updateEmployee(EmployeeData recieveData) throws InvalidIdException {

    String updateQueryHeader = "update employee_details set name = \"%s\", age=%d, gender=\"%s\", dob=\" %s\" where id=\"%d\";";

    System.out.println(recieveData);
    if (recieveData.getId() != null){


    }else{
      throw new InvalidIdException("Please enter valid Id");
    }

    return ("Employee Updated Successfully!...");
  }
}


