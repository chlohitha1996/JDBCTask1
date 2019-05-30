package com.stackroute.jdbcDemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
public class RowSetDemo {
    public void getAllStudents() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            PreparedStatement ps = connection.prepareStatement("select * from course");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("First column name: " + rsmd.getColumnName(1));
            System.out.println("First column datatype: " + rsmd.getColumnTypeName(1));


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

    public void getCourseByName(String name)
    {
        try {

            //Creating and Executing RowSet
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            Class.forName("com.mysql.cj.jdbc.Driver");
            rowSet.setUrl("jdbc:mysql://localhost:3306/student");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from course where name= lohitha");
            rowSet.execute();

            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Duration: " + rowSet.getString(3));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void getCourseByNameDuration(String name,int duration)
    {

        try {


            //Creating and Executing RowSet
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            Class.forName("com.mysql.cj.jdbc.Driver");
            rowSet.setUrl("jdbc:mysql://localhost:3306/student");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from course where name= lohi && duration=10");
            rowSet.execute();

            while (rowSet.next()) {
                int id = rowSet.getInt("id");
                String studentName = rowSet.getString("name");
                duration = Integer.parseInt(rowSet.getString("duration"));
                System.out.println(id+"\t"+studentName+"\t"+duration);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    }



