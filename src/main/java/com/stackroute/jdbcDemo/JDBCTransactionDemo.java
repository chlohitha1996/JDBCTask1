package com.stackroute.jdbcDemo;

import java.sql.*;

public class JDBCTransactionDemo {

    public void transactionData() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root@123");
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into course values(5,'Doreamon',12)");
            stmt.executeUpdate("insert into course values(6,'Nobitha',13)");


            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                System.out.println(name);
            }

            con.commit();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
