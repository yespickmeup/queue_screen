/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Settings {

    public static class to_settings {

        public final int id;
        public final String business_name;
        public final String address;
        public final String contact_no;
        public final String pool_host;
        public final int print_queue_no;
        public final String queue_server_ip;
        public final String queue_server_port;
        public final String location_screen_x;
        public final String location_screen_y;
        public final String font_size;
        public final String counter_no1_ip;
        public final String counter_no1_port;
        public final String counter_no2_ip;
        public final String counter_no2_port;
        public final String counter_no3_ip;
        public final String counter_no3_port;
        public final String counter_no4_ip;
        public final String counter_no4_port;
        public final String counter_no5_ip;
        public final String counter_no5_port;
        public final String counter_no6_ip;
        public final String counter_no6_port;
        public final String counter_no7_ip;
        public final String counter_no7_port;
        public final String counter_no8_ip;
        public final String counter_no8_port;
        public final String counter_no9_ip;
        public final String counter_no9_port;
        public final String counter_no10_ip;
        public final String counter_no10_port;
        public final String server_ip;
        public final String server_port;

        public to_settings(int id, String business_name, String address, String contact_no, String pool_host, int print_queue_no, String queue_server_ip, String queue_server_port, String location_screen_x, String location_screen_y, String font_size, String counter_no1_ip, String counter_no1_port, String counter_no2_ip, String counter_no2_port, String counter_no3_ip, String counter_no3_port, String counter_no4_ip, String counter_no4_port, String counter_no5_ip, String counter_no5_port, String counter_no6_ip, String counter_no6_port, String counter_no7_ip, String counter_no7_port, String counter_no8_ip, String counter_no8_port, String counter_no9_ip, String counter_no9_port, String counter_no10_ip, String counter_no10_port, String server_ip, String server_port) {
            this.id = id;
            this.business_name = business_name;
            this.address = address;
            this.contact_no = contact_no;
            this.pool_host = pool_host;
            this.print_queue_no = print_queue_no;
            this.queue_server_ip = queue_server_ip;
            this.queue_server_port = queue_server_port;
            this.location_screen_x = location_screen_x;
            this.location_screen_y = location_screen_y;
            this.font_size = font_size;
            this.counter_no1_ip = counter_no1_ip;
            this.counter_no1_port = counter_no1_port;
            this.counter_no2_ip = counter_no2_ip;
            this.counter_no2_port = counter_no2_port;
            this.counter_no3_ip = counter_no3_ip;
            this.counter_no3_port = counter_no3_port;
            this.counter_no4_ip = counter_no4_ip;
            this.counter_no4_port = counter_no4_port;
            this.counter_no5_ip = counter_no5_ip;
            this.counter_no5_port = counter_no5_port;
            this.counter_no6_ip = counter_no6_ip;
            this.counter_no6_port = counter_no6_port;
            this.counter_no7_ip = counter_no7_ip;
            this.counter_no7_port = counter_no7_port;
            this.counter_no8_ip = counter_no8_ip;
            this.counter_no8_port = counter_no8_port;
            this.counter_no9_ip = counter_no9_ip;
            this.counter_no9_port = counter_no9_port;
            this.counter_no10_ip = counter_no10_ip;
            this.counter_no10_port = counter_no10_port;
            this.server_ip = server_ip;
            this.server_port = server_port;
        }
    }

    public static void add_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into settings("
                    + "business_name"
                    + ",address"
                    + ",contact_no"
                    + ",pool_host"
                    + ",print_queue_no"
                    + ",queue_server_ip"
                    + ",queue_server_port"
                    + ",location_screen_x"
                    + ",location_screen_y"
                    + ",font_size"
                    + ",counter_no1_ip"
                    + ",counter_no1_port"
                    + ",counter_no2_ip"
                    + ",counter_no2_port"
                    + ",counter_no3_ip"
                    + ",counter_no3_port"
                    + ",counter_no4_ip"
                    + ",counter_no4_port"
                    + ",counter_no5_ip"
                    + ",counter_no5_port"
                    + ",counter_no6_ip"
                    + ",counter_no6_port"
                    + ",counter_no7_ip"
                    + ",counter_no7_port"
                    + ",counter_no8_ip"
                    + ",counter_no8_port"
                    + ",counter_no9_ip"
                    + ",counter_no9_port"
                    + ",counter_no10_ip"
                    + ",counter_no10_port"
                    + ",server_ip"
                    + ",server_port"
                    + ")values("
                    + ":business_name"
                    + ",:address"
                    + ",:contact_no"
                    + ",:pool_host"
                    + ",:print_queue_no"
                    + ",:queue_server_ip"
                    + ",:queue_server_port"
                    + ",:location_screen_x"
                    + ",:location_screen_y"
                    + ",:font_size"
                    + ",:counter_no1_ip"
                    + ",:counter_no1_port"
                    + ",:counter_no2_ip"
                    + ",:counter_no2_port"
                    + ",:counter_no3_ip"
                    + ",:counter_no3_port"
                    + ",:counter_no4_ip"
                    + ",:counter_no4_port"
                    + ",:counter_no5_ip"
                    + ",:counter_no5_port"
                    + ",:counter_no6_ip"
                    + ",:counter_no6_port"
                    + ",:counter_no7_ip"
                    + ",:counter_no7_port"
                    + ",:counter_no8_ip"
                    + ",:counter_no8_port"
                    + ",:counter_no9_ip"
                    + ",:counter_no9_port"
                    + ",:counter_no10_ip"
                    + ",:counter_no10_port"
                    + ",:server_ip"
                    + ",:server_port"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("business_name", to_settings.business_name)
                    .setString("address", to_settings.address)
                    .setString("contact_no", to_settings.contact_no)
                    .setString("pool_host", to_settings.pool_host)
                    .setNumber("print_queue_no", to_settings.print_queue_no)
                    .setString("queue_server_ip", to_settings.queue_server_ip)
                    .setString("queue_server_port", to_settings.queue_server_port)
                    .setString("location_screen_x", to_settings.location_screen_x)
                    .setString("location_screen_y", to_settings.location_screen_y)
                    .setString("font_size", to_settings.font_size)
                    .setString("counter_no1_ip", to_settings.counter_no1_ip)
                    .setString("counter_no1_port", to_settings.counter_no1_port)
                    .setString("counter_no2_ip", to_settings.counter_no2_ip)
                    .setString("counter_no2_port", to_settings.counter_no2_port)
                    .setString("counter_no3_ip", to_settings.counter_no3_ip)
                    .setString("counter_no3_port", to_settings.counter_no3_port)
                    .setString("counter_no4_ip", to_settings.counter_no4_ip)
                    .setString("counter_no4_port", to_settings.counter_no4_port)
                    .setString("counter_no5_ip", to_settings.counter_no5_ip)
                    .setString("counter_no5_port", to_settings.counter_no5_port)
                    .setString("counter_no6_ip", to_settings.counter_no6_ip)
                    .setString("counter_no6_port", to_settings.counter_no6_port)
                    .setString("counter_no7_ip", to_settings.counter_no7_ip)
                    .setString("counter_no7_port", to_settings.counter_no7_port)
                    .setString("counter_no8_ip", to_settings.counter_no8_ip)
                    .setString("counter_no8_port", to_settings.counter_no8_port)
                    .setString("counter_no9_ip", to_settings.counter_no9_ip)
                    .setString("counter_no9_port", to_settings.counter_no9_port)
                    .setString("counter_no10_ip", to_settings.counter_no10_ip)
                    .setString("counter_no10_port", to_settings.counter_no10_port)
                    .setString("server_ip", to_settings.server_ip)
                    .setString("server_port", to_settings.server_port)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update settings set "
                    + "business_name= :business_name "
                    + ",address= :address "
                    + ",contact_no= :contact_no "
                    + ",pool_host= :pool_host "
                    + ",print_queue_no= :print_queue_no "
                    + ",queue_server_ip= :queue_server_ip "
                    + ",queue_server_port= :queue_server_port "
                    + ",location_screen_x= :location_screen_x "
                    + ",location_screen_y= :location_screen_y "
                    + ",font_size= :font_size "
                    + ",counter_no1_ip= :counter_no1_ip "
                    + ",counter_no1_port= :counter_no1_port "
                    + ",counter_no2_ip= :counter_no2_ip "
                    + ",counter_no2_port= :counter_no2_port "
                    + ",counter_no3_ip= :counter_no3_ip "
                    + ",counter_no3_port= :counter_no3_port "
                    + ",counter_no4_ip= :counter_no4_ip "
                    + ",counter_no4_port= :counter_no4_port "
                    + ",counter_no5_ip= :counter_no5_ip "
                    + ",counter_no5_port= :counter_no5_port "
                    + ",counter_no6_ip= :counter_no6_ip "
                    + ",counter_no6_port= :counter_no6_port "
                    + ",counter_no7_ip= :counter_no7_ip "
                    + ",counter_no7_port= :counter_no7_port "
                    + ",counter_no8_ip= :counter_no8_ip "
                    + ",counter_no8_port= :counter_no8_port "
                    + ",counter_no9_ip= :counter_no9_ip "
                    + ",counter_no9_port= :counter_no9_port "
                    + ",counter_no10_ip= :counter_no10_ip "
                    + ",counter_no10_port= :counter_no10_port "
                    + ",server_ip= :server_ip "
                    + ",server_port= :server_port "
                    + " where id='" + to_settings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("business_name", to_settings.business_name)
                    .setString("address", to_settings.address)
                    .setString("contact_no", to_settings.contact_no)
                    .setString("pool_host", to_settings.pool_host)
                    .setNumber("print_queue_no", to_settings.print_queue_no)
                    .setString("queue_server_ip", to_settings.queue_server_ip)
                    .setString("queue_server_port", to_settings.queue_server_port)
                    .setString("location_screen_x", to_settings.location_screen_x)
                    .setString("location_screen_y", to_settings.location_screen_y)
                    .setString("font_size", to_settings.font_size)
                    .setString("counter_no1_ip", to_settings.counter_no1_ip)
                    .setString("counter_no1_port", to_settings.counter_no1_port)
                    .setString("counter_no2_ip", to_settings.counter_no2_ip)
                    .setString("counter_no2_port", to_settings.counter_no2_port)
                    .setString("counter_no3_ip", to_settings.counter_no3_ip)
                    .setString("counter_no3_port", to_settings.counter_no3_port)
                    .setString("counter_no4_ip", to_settings.counter_no4_ip)
                    .setString("counter_no4_port", to_settings.counter_no4_port)
                    .setString("counter_no5_ip", to_settings.counter_no5_ip)
                    .setString("counter_no5_port", to_settings.counter_no5_port)
                    .setString("counter_no6_ip", to_settings.counter_no6_ip)
                    .setString("counter_no6_port", to_settings.counter_no6_port)
                    .setString("counter_no7_ip", to_settings.counter_no7_ip)
                    .setString("counter_no7_port", to_settings.counter_no7_port)
                    .setString("counter_no8_ip", to_settings.counter_no8_ip)
                    .setString("counter_no8_port", to_settings.counter_no8_port)
                    .setString("counter_no9_ip", to_settings.counter_no9_ip)
                    .setString("counter_no9_port", to_settings.counter_no9_port)
                    .setString("counter_no10_ip", to_settings.counter_no10_ip)
                    .setString("counter_no10_port", to_settings.counter_no10_port)
                    .setString("server_ip", to_settings.server_ip)
                    .setString("server_port", to_settings.server_port)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_settings to_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from settings  "
                    + " where id='" + to_settings.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Settings.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_settings> ret_data(String where) {
        List<to_settings> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",business_name"
                    + ",address"
                    + ",contact_no"
                    + ",pool_host"
                    + ",print_queue_no"
                    + ",queue_server_ip"
                    + ",queue_server_port"
                    + ",location_screen_x"
                    + ",location_screen_y"
                    + ",font_size"
                    + ",counter_no1_ip"
                    + ",counter_no1_port"
                    + ",counter_no2_ip"
                    + ",counter_no2_port"
                    + ",counter_no3_ip"
                    + ",counter_no3_port"
                    + ",counter_no4_ip"
                    + ",counter_no4_port"
                    + ",counter_no5_ip"
                    + ",counter_no5_port"
                    + ",counter_no6_ip"
                    + ",counter_no6_port"
                    + ",counter_no7_ip"
                    + ",counter_no7_port"
                    + ",counter_no8_ip"
                    + ",counter_no8_port"
                    + ",counter_no9_ip"
                    + ",counter_no9_port"
                    + ",counter_no10_ip"
                    + ",counter_no10_port"
                    + ",server_ip"
                    + ",server_port"
                    + " from settings"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String business_name = rs.getString(2);
                String address = rs.getString(3);
                String contact_no = rs.getString(4);
                String pool_host = rs.getString(5);
                int print_queue_no = rs.getInt(6);
                String queue_server_ip = rs.getString(7);
                String queue_server_port = rs.getString(8);
                String location_screen_x = rs.getString(9);
                String location_screen_y = rs.getString(10);
                String font_size = rs.getString(11);
                String counter_no1_ip = rs.getString(12);
                String counter_no1_port = rs.getString(13);
                String counter_no2_ip = rs.getString(14);
                String counter_no2_port = rs.getString(15);
                String counter_no3_ip = rs.getString(16);
                String counter_no3_port = rs.getString(17);
                String counter_no4_ip = rs.getString(18);
                String counter_no4_port = rs.getString(19);
                String counter_no5_ip = rs.getString(20);
                String counter_no5_port = rs.getString(21);
                String counter_no6_ip = rs.getString(22);
                String counter_no6_port = rs.getString(23);
                String counter_no7_ip = rs.getString(24);
                String counter_no7_port = rs.getString(25);
                String counter_no8_ip = rs.getString(26);
                String counter_no8_port = rs.getString(27);
                String counter_no9_ip = rs.getString(28);
                String counter_no9_port = rs.getString(29);
                String counter_no10_ip = rs.getString(30);
                String counter_no10_port = rs.getString(31);
                String server_ip = rs.getString(32);
                String server_port = rs.getString(33);

                to_settings to = new to_settings(id, business_name, address, contact_no, pool_host, print_queue_no, queue_server_ip, queue_server_port, location_screen_x, location_screen_y, font_size, counter_no1_ip, counter_no1_port, counter_no2_ip, counter_no2_port, counter_no3_ip, counter_no3_port, counter_no4_ip, counter_no4_port, counter_no5_ip, counter_no5_port, counter_no6_ip, counter_no6_port, counter_no7_ip, counter_no7_port, counter_no8_ip, counter_no8_port, counter_no9_ip, counter_no9_port, counter_no10_ip, counter_no10_port, server_ip, server_port);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
