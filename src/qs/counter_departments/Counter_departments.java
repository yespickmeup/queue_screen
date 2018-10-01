/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.counter_departments;

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
public class Counter_departments {

    public static class to_counter_departments {

        public final int id;
        public final String counter_id;
        public final String counter;
        public String department_id;
        public String department;
        public final String created_at;
        public final String updated_at;
        public final int status;
        public int priority;

        public to_counter_departments(int id, String counter_id, String counter, String department_id, String department, String created_at, String updated_at, int status, int priority) {
            this.id = id;
            this.counter_id = counter_id;
            this.counter = counter;
            this.department_id = department_id;
            this.department = department;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.status = status;
            this.priority = priority;
        }

        public String getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(String department_id) {
            this.department_id = department_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
        
    }

    public static void add_data(to_counter_departments to_counter_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into counter_departments("
                    + "counter_id"
                    + ",counter"
                    + ",department_id"
                    + ",department"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",priority"
                    + ")values("
                    + ":counter_id"
                    + ",:counter"
                    + ",:department_id"
                    + ",:department"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:status"
                    + ",:priority"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter_id", to_counter_departments.counter_id)
                    .setString("counter", to_counter_departments.counter)
                    .setString("department_id", to_counter_departments.department_id)
                    .setString("department", to_counter_departments.department)
                    .setString("created_at", to_counter_departments.created_at)
                    .setString("updated_at", to_counter_departments.updated_at)
                    .setNumber("status", to_counter_departments.status)
                    .setNumber("priority", to_counter_departments.priority)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counter_departments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_counter_departments to_counter_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update counter_departments set "
                    + "counter_id= :counter_id "
                    + ",counter= :counter "
                    + ",department_id= :department_id "
                    + ",department= :department "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",status= :status "
                    + ",priority= :priority "
                    + " where id='" + to_counter_departments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter_id", to_counter_departments.counter_id)
                    .setString("counter", to_counter_departments.counter)
                    .setString("department_id", to_counter_departments.department_id)
                    .setString("department", to_counter_departments.department)
                    .setString("created_at", to_counter_departments.created_at)
                    .setString("updated_at", to_counter_departments.updated_at)
                    .setNumber("status", to_counter_departments.status)
                    .setNumber("priority", to_counter_departments.priority)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counter_departments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_counter_departments to_counter_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from counter_departments  "
                    + " where id='" + to_counter_departments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counter_departments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_counter_departments> ret_data(String where) {
        List<to_counter_departments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",counter_id"
                    + ",counter"
                    + ",department_id"
                    + ",department"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",priority"
                    + " from counter_departments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String counter_id = rs.getString(2);
                String counter = rs.getString(3);
                String department_id = rs.getString(4);
                String department = rs.getString(5);
                String created_at = rs.getString(6);
                String updated_at = rs.getString(7);
                int status = rs.getInt(8);
                int priority = rs.getInt(9);

                to_counter_departments to = new to_counter_departments(id, counter_id, counter, department_id, department, created_at, updated_at, status, priority);
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
