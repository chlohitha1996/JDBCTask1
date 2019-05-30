package com.stackroute.jdbcDemo;

import java.sql.*;

public class ResultSetMetaDetaDemo {
    public void getAllStudents() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            PreparedStatement ps = connection.prepareStatement("select * from course");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Number of columns: " + rsmd.getColumnCount());
            System.out.println("First Column name: " + rsmd.getColumnName(1));
            System.out.println("First Column Datatype: " + rsmd.getColumnTypeName(1));

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}


