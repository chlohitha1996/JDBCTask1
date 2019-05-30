package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcBatchProcessing {

    public void getAllStudents() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            Statement statement = connection.createStatement();
            // Create statement object
            Statement stmt = connection.createStatement();

            // Set auto-commit to false
            connection.setAutoCommit(false);

            // Create SQL statement
            String SQL = "INSERT INTO course (id, name,duration) " +
                    "VALUES(7,'Vijay', 30)";
            // Add above SQL statement in the batch.
            stmt.addBatch(SQL);

            // Create one more SQL statement
            SQL = "INSERT INTO course (id,name,duration) " +
                    "VALUES(8,'Anusha', 35)";
            // Add above SQL statement in the batch.
            stmt.addBatch(SQL);

            // Create one more SQL statement
            SQL = "UPDATE course SET duration = 35 " +
                    "WHERE id = 7";
            // Add above SQL statement in the batch.
            stmt.addBatch(SQL);

            // Create an int[] to hold returned values
            int[] count = stmt.executeBatch();

            //Explicitly commit statements to apply changes
            connection.commit();


            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                System.out.println(name);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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