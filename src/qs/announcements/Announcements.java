/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.announcements;

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
public class Announcements {

    public static class to_announcements {

        public final int id;
        public final String announcement;
        public final String date_from;
        public final String date_to;
        public final int status;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;

        public to_announcements(int id, String announcement, String date_from, String date_to, int status, String created_at, String updated_at, String created_by, String updated_by) {
            this.id = id;
            this.announcement = announcement;
            this.date_from = date_from;
            this.date_to = date_to;
            this.status = status;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
        }
    }

    public static void add_data(to_announcements to_announcements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into announcements("
                    + "announcement"
                    + ",date_from"
                    + ",date_to"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ")values("
                    + ":announcement"
                    + ",:date_from"
                    + ",:date_to"
                    + ",:status"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("announcement", to_announcements.announcement)
                    .setString("date_from", to_announcements.date_from)
                    .setString("date_to", to_announcements.date_to)
                    .setNumber("status", to_announcements.status)
                    .setString("created_at", to_announcements.created_at)
                    .setString("updated_at", to_announcements.updated_at)
                    .setString("created_by", to_announcements.created_by)
                    .setString("updated_by", to_announcements.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Announcements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_announcements to_announcements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update announcements set "
                    + "announcement= :announcement "
                    + ",date_from= :date_from "
                    + ",date_to= :date_to "
                    + ",status= :status "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + " where id='" + to_announcements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("announcement", to_announcements.announcement)
                    .setString("date_from", to_announcements.date_from)
                    .setString("date_to", to_announcements.date_to)
                    .setNumber("status", to_announcements.status)
                    .setString("created_at", to_announcements.created_at)
                    .setString("updated_at", to_announcements.updated_at)
                    .setString("created_by", to_announcements.created_by)
                    .setString("updated_by", to_announcements.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Announcements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_announcements to_announcements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from announcements  "
                    + " where id='" + to_announcements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Announcements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_announcements> ret_data(String where) {
        List<to_announcements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",announcement"
                    + ",date_from"
                    + ",date_to"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from announcements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String announcement = rs.getString(2);
                String date_from = rs.getString(3);
                String date_to = rs.getString(4);
                int status = rs.getInt(5);
                String created_at = rs.getString(6);
                String updated_at = rs.getString(7);
                String created_by = rs.getString(8);
                String updated_by = rs.getString(9);

                to_announcements to = new to_announcements(id, announcement, date_from, date_to, status, created_at, updated_at, created_by, updated_by);
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
