package com.test.demo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class KingBaseTest {
    public static void main(String[] args) throws SQLException {
        System.out.println("kaishi");
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.kingbase8.Driver");

//            String URL="jdbc:kingbase8://192.168.112.49:54321/idm";
//            String USER="system";
//            String PASSWORD="123456";

            String URL="jdbc:kingbase8://192.3.89.62:54321/gzwceshi";
            String USER="gzwceshi";
            String PASSWORD="gzwceshi";

            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            st=conn.createStatement();
//            ResultSet rs=st.executeQuery("select * from user_info");
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }
}
