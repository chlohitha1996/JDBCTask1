package com.stackroute;

import com.stackroute.jdbcDemo.*;

import javax.sql.rowset.JdbcRowSet;
import java.sql.DatabaseMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        //DataBaseMetaData DEmo
        System.out.println("Data Base Meta Data Demo:");
        DataBaseMetaDataDemo dbmd= new DataBaseMetaDataDemo();
        dbmd.Meta();


        //Datamanager
        Datamanager datamanager=new Datamanager();
        //datamanager.getAllStudents();


        //JDBC Batch Processing
        System.out.println("JDBC Batch Processing Demo:");
        JdbcBatchProcessing jdbcT=new JdbcBatchProcessing();
        jdbcT.getAllStudents();


        //JDBC Transaction
        System.out.println("JDBC Transaction Demo:");
        JDBCTransactionDemo jdbcTransactionDemo=new JDBCTransactionDemo();
        jdbcTransactionDemo.transactionData();


        //Prepare Statement
        System.out.println("Prepare Statement:");
        PrepareStatementDemo prepareStatementDemo=new PrepareStatementDemo();
        prepareStatementDemo.getCourseByName("lohitha");
        prepareStatementDemo.getCourseByNameDuration("lohitha",11);
        RowSetDemo rowSetDemo=new RowSetDemo();


        //Result Set Meta Data

        System.out.println("Result set:");
        ResultSetMetaDetaDemo resultSetMetaDetaDemo =new ResultSetMetaDetaDemo();
        resultSetMetaDetaDemo.getAllStudents();

        //RowSetDemo
      //  rowSetDemo.getAllStudents();
       //rowSetDemo.getCourseByName("lohitha");





    }
}
