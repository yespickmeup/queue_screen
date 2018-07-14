/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.counters;

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
public class Counters {

    public static class to_counters {

        public final int id;
        public final String counter;
        public final String department;
        public final String department_id;
        public final String ip_address;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;

        public to_counters(int id, String counter, String department, String department_id, String ip_address, String created_at, String updated_at, String created_by, String updated_by, int status) {
            this.id = id;
            this.counter = counter;
            this.department = department;
            this.department_id = department_id;
            this.ip_address = ip_address;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
        }
    }

    public static void add_data(to_counters to_counters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into counters("
                    + "counter"
                    + ",department"
                    + ",department_id"
                    + ",ip_address"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ")values("
                    + ":counter"
                    + ",:department"
                    + ",:department_id"
                    + ",:ip_address"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter", to_counters.counter)
                    .setString("department", to_counters.department)
                    .setString("department_id", to_counters.department_id)
                    .setString("ip_address", to_counters.ip_address)
                    .setString("created_at", to_counters.created_at)
                    .setString("updated_at", to_counters.updated_at)
                    .setString("created_by", to_counters.created_by)
                    .setString("updated_by", to_counters.updated_by)
                    .setNumber("status", to_counters.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counters.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_counters to_counters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update counters set "
                    + "counter= :counter "
                    + ",department= :department "
                    + ",department_id= :department_id "
                    + ",ip_address= :ip_address "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + " where id='" + to_counters.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter", to_counters.counter)
                    .setString("department", to_counters.department)
                    .setString("department_id", to_counters.department_id)
                    .setString("ip_address", to_counters.ip_address)
                    .setString("created_at", to_counters.created_at)
                    .setString("updated_at", to_counters.updated_at)
                    .setString("created_by", to_counters.created_by)
                    .setString("updated_by", to_counters.updated_by)
                    .setNumber("status", to_counters.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counters.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_counters to_counters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from counters  "
                    + " where id='" + to_counters.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counters.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_counters> ret_data(String where) {
        List<to_counters> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",counter"
                    + ",department"
                    + ",department_id"
                    + ",ip_address"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from counters"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String counter = rs.getString(2);
                String department = rs.getString(3);
                String department_id = rs.getString(4);
                String ip_address = rs.getString(5);
                String created_at = rs.getString(6);
                String updated_at = rs.getString(7);
                String created_by = rs.getString(8);
                String updated_by = rs.getString(9);
                int status = rs.getInt(10);

                to_counters to = new to_counters(id, counter, department, department_id, ip_address, created_at, updated_at, created_by, updated_by, status);
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
