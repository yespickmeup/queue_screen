/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.users;

/**
 *
 * @author Guinness
 */
public class MyUser1 {

    public static String user_id;
    public static String user_name;
    public static String user_screen_name;
    public static String branch;
    public static String branch_id;
    public static String location;
    public static String location_id;

    public MyUser1() {
    }

    public static String getBranch() {
        if (branch == null) {
            return "";
        }
        return branch;
    }

    public static void setBranch(String branch) {
        MyUser1.branch = branch;
    }

    public static String getBranch_id() {
        if (branch_id == null) {
            return "";

        }
        return branch_id;
    }

    public static void setBranch_id(String branch_id) {
        MyUser1.branch_id = branch_id;
    }

    public static String getLocation() {
        if (location == null) {
            return "";
        }
        return location;
    }

    public static void setLocation(String location) {
        MyUser1.location = location;
    }

    public static String getLocation_id() {
        if (location_id == null) {
            return "";
        }
        return location_id;
    }

    public static void setLocation_id(String location_id) {
        MyUser1.location_id = location_id;
    }

    public static String getUser_id() {
        if (user_id == null) {
            return "";
        }
        return user_id;
    }

    public static void setUser_id(String user_id) {
        MyUser1.user_id = user_id;
    }

    public static String getUser_name() {
        if (user_name == null) {
            return "";
        }
        return user_name;
    }

    public void setUser_name(String user_name) {
        MyUser1.user_name = user_name;
    }

    public static String getUser_screen_name() {
        if (user_screen_name == null) {
            return "";
        }
        return user_screen_name;
    }

    public void setUser_screen_name(String user_screen_name) {
        MyUser1.user_screen_name = user_screen_name;
    }

//    public static List<to_users> ret_data(String where) {
//        List<to_users> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",screen_name"
//                    + ",user_name"
//                    + ",password"
//                    + ",user_level"
//                    + ",date_added"
//                    + ",is_active"
//                    + ",t_sales"
//                    + ",t_receipts"
//                    + ",t_stock_transfer"
//                    + ",m_items"
//                    + ",m_category"
//                    + ",m_users"
//                    + ",m_uom"
//                    + ",m_suppliers"
//                    + ",r_sales"
//                    + ",r_cash_count"
//                    + ",r_receipts"
//                    + ",r_stock_transferred"
//                    + ",r_stock_take"
//                    + ",m_customers"
//                    + ",m_discount"
//                    + ",m_banks"
//                    + ",r_stock_left_supplier"
//                    + ",t_inventory_adjuster"
//                    + ",t_salesman"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + " from users"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String screen_name = rs.getString(2);
//                String user_name1 = rs.getString(3);
//                String password = rs.getString(4);
//                int user_level = rs.getInt(5);
//                String date_added = rs.getString(6);
//                int is_active = rs.getInt(7);
//                String t_sales = rs.getString(8);
//                String t_receipts = rs.getString(9);
//                String t_stock_transfer = rs.getString(10);
//                String m_items = rs.getString(11);
//                String m_category = rs.getString(12);
//                String m_users = rs.getString(13);
//                String m_uom = rs.getString(14);
//                String m_suppliers = rs.getString(15);
//                String r_sales = rs.getString(16);
//                String r_cash_count = rs.getString(17);
//                String r_receipts = rs.getString(18);
//                String r_stock_transferred = rs.getString(19);
//                String r_stock_take = rs.getString(20);
//                String m_customers = rs.getString(21);
//                String m_discount = rs.getString(22);
//                String m_banks = rs.getString(23);
//                String r_stock_left_supplier = rs.getString(24);
//                String t_inventory_adjuster = rs.getString(25);
//                String t_salesman = rs.getString(26);
//                String branch1 = rs.getString(27);
//                String branch_id1 = rs.getString(28);
//                String location1 = rs.getString(29);
//                String location_id1 = rs.getString(30);
//                to_users to = new to_users(id, screen_name, user_name1, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch1, branch_id1, location1, location_id1);
//                String where2 = " where user_id='" + id + "' and previledge like '" + "Sales" + "'";
//                List<S1_user_previleges.to_user_previleges> datas2 = S1_user_previleges.ret_data(where2);
//                if (datas2.size() == 1) {
//                    datas.add(to);
//                }
//
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static List<to_users> ret_data2(String where) {
//        List<to_users> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",screen_name"
//                    + ",user_name"
//                    + ",password"
//                    + ",user_level"
//                    + ",date_added"
//                    + ",is_active"
//                    + ",t_sales"
//                    + ",t_receipts"
//                    + ",t_stock_transfer"
//                    + ",m_items"
//                    + ",m_category"
//                    + ",m_users"
//                    + ",m_uom"
//                    + ",m_suppliers"
//                    + ",r_sales"
//                    + ",r_cash_count"
//                    + ",r_receipts"
//                    + ",r_stock_transferred"
//                    + ",r_stock_take"
//                    + ",m_customers"
//                    + ",m_discount"
//                    + ",m_banks"
//                    + ",r_stock_left_supplier"
//                    + ",t_inventory_adjuster"
//                    + ",t_salesman"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + " from users"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String screen_name = rs.getString(2);
//                String user_name1 = rs.getString(3);
//                String password = rs.getString(4);
//                int user_level = rs.getInt(5);
//                String date_added = rs.getString(6);
//                int is_active = rs.getInt(7);
//                String t_sales = rs.getString(8);
//                String t_receipts = rs.getString(9);
//                String t_stock_transfer = rs.getString(10);
//                String m_items = rs.getString(11);
//                String m_category = rs.getString(12);
//                String m_users = rs.getString(13);
//                String m_uom = rs.getString(14);
//                String m_suppliers = rs.getString(15);
//                String r_sales = rs.getString(16);
//                String r_cash_count = rs.getString(17);
//                String r_receipts = rs.getString(18);
//                String r_stock_transferred = rs.getString(19);
//                String r_stock_take = rs.getString(20);
//                String m_customers = rs.getString(21);
//                String m_discount = rs.getString(22);
//                String m_banks = rs.getString(23);
//                String r_stock_left_supplier = rs.getString(24);
//                String t_inventory_adjuster = rs.getString(25);
//                String t_salesman = rs.getString(26);
//                String branch1 = rs.getString(27);
//                String branch_id1 = rs.getString(28);
//                String location1 = rs.getString(29);
//                String location_id1 = rs.getString(30);
//                to_users to = new to_users(id, screen_name, user_name1, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch1, branch_id1, location1, location_id1);
//
//                datas.add(to);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }

}
