/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author i1
 */
public class MyConnection1 {

    private MyConnection1() {
    }
    private static MyConnection1 connection;

    
    private static Connection conn;

    public static Connection connect() {
        try {
            String host = System.getProperty("pool_host", "31.170.166.181:21");
            String user = System.getProperty("pool_user", "u934783048_syn");
            String password = System.getProperty("pool_password", "password");
            String db_name = System.getProperty("mydb", "u934783048_syn");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");

            String s0 = "select name from users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("NO!!!");
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        connect();
    }
}
