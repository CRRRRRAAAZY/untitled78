package com.example.DBTest;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



public class MyDB {

    private static Connection conn=null;

    static String user="root";

    static String pwd="120110";

    static String url="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8";

    public static Connection getConn() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, pwd);

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        try {

            if(conn.isClosed()) {

                System.out.println("Á¬½ÓÊ§°Ü");

                return null;

            }

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        return conn;

    }



}