package com.restAPI.controllers;

import com.restAPI.wrapper.LeadData;

import java.sql.*;
import java.util.ArrayList;

public class LeadApiController {


//    get all data from database
    public static ArrayList<LeadData> getLeadData(){
        ArrayList<LeadData> result = new ArrayList();

        String selectLeadData = "SELECT * FROM componydb.lead_details;";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
            PreparedStatement preparedStatement = conn.prepareStatement(selectLeadData);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String leadEmail = resultSet.getString("email");
                String contact = resultSet.getString("contact");
                String experience = resultSet.getString("experience");
                String previousCompany = resultSet.getString("previous_company");
                Integer expectedSalary = resultSet.getInt("expected_salary");
                String description = resultSet.getString("description");
                String gender = resultSet.getString("gender");

                LeadData obj = new LeadData();
                obj.setId(id);
                obj.setFullName(fullName);
                obj.setEmail(leadEmail);
                obj.setContact(contact);
                obj.setExperience(experience);
                obj.setPreviousCompany(previousCompany);
                obj.setExpectedSalary(expectedSalary);
                obj.setDescription(description);
                obj.setGender(gender);
                result.add(obj);
            }

        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }

        return result;
    }

    public static ArrayList<LeadData> findLeadData(Integer leadId){
        ArrayList<LeadData> result = new ArrayList();

        String selectLeadData = "SELECT * FROM componydb.lead_details WHERE id = %d;";
        selectLeadData = String.format(selectLeadData, leadId);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
            PreparedStatement preparedStatement = conn.prepareStatement(selectLeadData);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String leadEmail = resultSet.getString("email");
                String contact = resultSet.getString("contact");
                String experience = resultSet.getString("experience");
                String previousCompany = resultSet.getString("previous_company");
                Integer expectedSalary = resultSet.getInt("expected_salary");
                String description = resultSet.getString("description");
                String gender = resultSet.getString("gender");

                LeadData obj = new LeadData();
                obj.setId(id);
                obj.setFullName(fullName);
                obj.setEmail(leadEmail);
                obj.setContact(contact);
                obj.setExperience(experience);
                obj.setPreviousCompany(previousCompany);
                obj.setExpectedSalary(expectedSalary);
                obj.setDescription(description);
                obj.setGender(gender);
                result.add(obj);
            }

        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }

        return result;
    }
//    add lead Information
    public static Integer addLeadData(LeadData recieveData){
            String insertQuery = "INSERT INTO lead_details (full_name, email, contact, experience, previous_company, expected_salary, description, gender) VALUES ('%s', '%s', %s,'%s', '%s', %d, '%s', '%s');";
            insertQuery = String.format(insertQuery, recieveData.getFullName(), recieveData.getEmail(),recieveData.getContact(), recieveData.getExperience(), recieveData.getPreviousCompany(), recieveData.getExpectedSalary(), recieveData.getDescription(), recieveData.getGender());
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recieveData.getId();
    }

//    delete record in a table
    public static Boolean deleteLeadData(Integer leadId){
        String deleteLead =  "delete from lead_details where id = %d;";
        deleteLead = String.format(deleteLead, leadId);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(deleteLead)) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static Integer  updateLeadData(Integer receiveId, LeadData recieveData){
        String updateLeadData =  "UPDATE lead_details SET full_name = '%s', email = '%s', contact = '%s', experience = '%s', previous_company = '%s', expected_salary = %d, description = '%s', gender = '%s' WHERE id = %d";
        updateLeadData = String.format(updateLeadData, recieveData.getFullName(), recieveData.getEmail(),recieveData.getContact(), recieveData.getExperience(), recieveData.getPreviousCompany(), recieveData.getExpectedSalary(), recieveData.getDescription(), recieveData.getGender(), receiveId);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/componydb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(updateLeadData)) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(recieveData);
        return receiveId;

    }
}
