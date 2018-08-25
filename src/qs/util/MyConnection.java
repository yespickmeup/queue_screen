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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class MyConnection {

    private MyConnection() {
    }
    private static MyConnection connection;

    private static void init() {
        if (connection == null) {
            connection = new MyConnection();
        }
    }
    private static Connection conn;
    private static Connection conn2;
    static String hosts = "localhost:3306";

    public static Connection connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection connect3() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection connect2() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/";

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();

                conn = null;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static Connection cloud_connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "128.199.80.53");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn2 = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn2;
    }

    public static void main(String[] args) {
        int connected = check_cloud_connection();
        System.out.println("Is Connected: " + connected);
    }

    public static int check_cloud_connection() {
        int connected = 0;

        String host = System.getProperty("cloud_host", "128.199.80.53");
        String port = System.getProperty("cloud_port", "3306");
        host = host + ":" + port;
        String user = System.getProperty("cloud_user", "root");
        String password = System.getProperty("cloud_password", "synapse246");
        String db_name = System.getProperty("cloud_db", "db_queue");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;
            try {
                Connection conn1 = DriverManager.getConnection(url, user, password);
                String s0 = "select "
                        + " id"
                        + " from users"
                        + " limit 1";
                Statement stmt = conn1.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                if (rs.next()) {
                    connected = 1;
                }
            } catch (SQLException ex) {
                return 0;
            }
        } catch (ClassNotFoundException ex) {
            return 0;
        }
        return connected;

    }

    public static Connection development() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection production() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "192.168.1.51");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "synapse246");
            String db_name = System.getProperty("pool_db", "db_queue");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
