package com.restapi.databaseconnection;

import java.sql.DriverManager;
import java.sql.*;


public class DBconnection {
    public static void main(String[] args) {

        System.out.println("MySQL JDBC Connection Testing");

        String SQL_SELECT = "select * from student_details;";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb", "root", "Root@123");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {



            ResultSet resultSet = preparedStatement.executeQuery();


            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " " + columnValue  );
                }
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}












