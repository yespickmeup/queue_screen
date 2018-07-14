/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Ronald
 */
public class CheckConnection implements Runnable {

    int i = 1;
    Timer t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection conn = MyConnection.connect();
                String s0 = "select "
                        + " * from branches  limit 1"
                        + " ";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                if (rs.next()) {
                    int id = rs.getInt(1);
//                    System.out.println("Connected" + " : " + i);
                    i++;
                } else {
                    JOptionPane.showMessageDialog(null, "No Connection!!!, Program will exit.");
                    System.exit(1);
                }

            } catch (SQLException e2) {
                throw new RuntimeException(e2);
            } finally {
                MyConnection.close();
//                        System.out.println("Connection Closed");
            }
        }
    });

    @Override
    public void run() {

        while (true) {
            t.start();
        }
    }

    public static void main(String[] args) {
        CheckConnection myRunnable = new CheckConnection();
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }

    static int z = 1;

    public static void main3(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(z);
                z++;
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(r);
    }
}
