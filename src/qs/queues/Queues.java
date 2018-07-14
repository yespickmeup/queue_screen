/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.queues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.users.MyUser1;
import qs.util.DateType;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Queues {

    public static class to_queues {

        public final int id;
        public final String queue_no;
        public final String department;
        public final String department_id;
        public final String customer;
        public final String customer_id;
        public final String counter_no;
        public final String teller;
        public final String teller_id;
        public final String remarks;
        public final int status;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;

        public to_queues(int id, String queue_no, String department, String department_id, String customer, String customer_id, String counter_no, String teller, String teller_id, String remarks, int status, String created_at, String updated_at, String created_by, String updated_by) {
            this.id = id;
            this.queue_no = queue_no;
            this.department = department;
            this.department_id = department_id;
            this.customer = customer;
            this.customer_id = customer_id;
            this.counter_no = counter_no;
            this.teller = teller;
            this.teller_id = teller_id;
            this.remarks = remarks;
            this.status = status;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
        }
    }

    public static void add_data(to_queues to_queues) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into queues("
                    + "queue_no"
                    + ",department"
                    + ",department_id"
                    + ",customer"
                    + ",customer_id"
                    + ",counter_no"
                    + ",teller"
                    + ",teller_id"
                    + ",remarks"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ")values("
                    + ":queue_no"
                    + ",:department"
                    + ",:department_id"
                    + ",:customer"
                    + ",:customer_id"
                    + ",:counter_no"
                    + ",:teller"
                    + ",:teller_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("queue_no", to_queues.queue_no)
                    .setString("department", to_queues.department)
                    .setString("department_id", to_queues.department_id)
                    .setString("customer", to_queues.customer)
                    .setString("customer_id", to_queues.customer_id)
                    .setString("counter_no", to_queues.counter_no)
                    .setString("teller", to_queues.teller)
                    .setString("teller_id", to_queues.teller_id)
                    .setString("remarks", to_queues.remarks)
                    .setNumber("status", to_queues.status)
                    .setString("created_at", to_queues.created_at)
                    .setString("updated_at", to_queues.updated_at)
                    .setString("created_by", to_queues.created_by)
                    .setString("updated_by", to_queues.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Queues.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_queues to_queues) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update queues set "
                    + "queue_no= :queue_no "
                    + ",department= :department "
                    + ",department_id= :department_id "
                    + ",customer= :customer "
                    + ",customer_id= :customer_id "
                    + ",counter_no= :counter_no "
                    + ",teller= :teller "
                    + ",teller_id= :teller_id "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + " where id='" + to_queues.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("queue_no", to_queues.queue_no)
                    .setString("department", to_queues.department)
                    .setString("department_id", to_queues.department_id)
                    .setString("customer", to_queues.customer)
                    .setString("customer_id", to_queues.customer_id)
                    .setString("counter_no", to_queues.counter_no)
                    .setString("teller", to_queues.teller)
                    .setString("teller_id", to_queues.teller_id)
                    .setString("remarks", to_queues.remarks)
                    .setNumber("status", to_queues.status)
                    .setString("created_at", to_queues.created_at)
                    .setString("updated_at", to_queues.updated_at)
                    .setString("created_by", to_queues.created_by)
                    .setString("updated_by", to_queues.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Queues.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_queue(int id, int status) {
        try {
            String date = DateType.now();
            String user = MyUser1.getUser_id();
            Connection conn = MyConnection.connect();
            String s0 = "update queues set "
                    + " status= :status "
                    + ",updated_at= :updated_at "
                    + ",updated_by= :updated_by "
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", status)
                    .setString("updated_at", date)
                    .setString("updated_by", user)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Queues.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_teller(int id, String counter_no,String teller,String teller_id) {
        try {
            String date = DateType.now();
            String user = MyUser1.getUser_id();
            Connection conn = MyConnection.connect();
            String s0 = "update queues set "
                    + " counter_no= :counter_no "
                    + ",teller= :teller "
                    + ",teller_id= :teller_id "
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter_no", counter_no)
                    .setString("teller", teller)
                    .setString("teller_id", teller_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Queues.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_queues to_queues) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from queues  "
                    + " where id='" + to_queues.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Queues.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_queues> ret_data(String where) {
        List<to_queues> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",queue_no"
                    + ",department"
                    + ",department_id"
                    + ",customer"
                    + ",customer_id"
                    + ",counter_no"
                    + ",teller"
                    + ",teller_id"
                    + ",remarks"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from queues"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String queue_no = rs.getString(2);
                String department = rs.getString(3);
                String department_id = rs.getString(4);
                String customer = rs.getString(5);
                String customer_id = rs.getString(6);
                String counter_no = rs.getString(7);
                String teller = rs.getString(8);
                String teller_id = rs.getString(9);
                String remarks = rs.getString(10);
                int status = rs.getInt(11);
                String created_at = rs.getString(12);
                String updated_at = rs.getString(13);
                String created_by = rs.getString(14);
                String updated_by = rs.getString(15);

                to_queues to = new to_queues(id, queue_no, department, department_id, customer, customer_id, counter_no, teller, teller_id, remarks, status, created_at, updated_at, created_by, updated_by);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String department, String department_id) {
        String f_letter = department.substring(0, 1);
        String id = f_letter + "00000";
        String date = DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from queues where Date(created_at)='" + date + "' and department_id='" + department_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select queue_no from queues where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "00000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
