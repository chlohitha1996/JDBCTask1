package com.stackroute.jdbcDemo;

import java.sql.*;

public class PrepareStatementDemo {
    public void getCourseByName(String name) {
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            String sql = "select * from course where name=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String studentName = result.getString("name");
                String duration = result.getString("duration");
                System.out.println(id+"\t"+studentName+"\t"+duration);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getCourseByNameDuration(String name,int duration) {
        Connection connection = null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            String sql = "select * from course where name=? and duration=? ";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, duration);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String studentName = result.getString("name");
                String durationStudent = result.getString("duration");
                System.out.println(id + "\t" + studentName + "\t" + durationStudent);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
