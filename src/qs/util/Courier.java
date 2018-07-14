/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class Courier {

    public static class status {

        public final int id;
        public final String status;

        public status(int id, String status) {
            this.id = id;
            this.status = status;
        }

    }

    public static List<status> status() {
        List<status> datas = new ArrayList();
        status t1 = new status(1, "Active");
        status t2 = new status(0, "Inactive");
        datas.add(t1);
        datas.add(t2);
        return datas;
    }

    public static List<status> receipt_types() {
        List<status> datas = new ArrayList();
        status t1 = new status(1, "Receipt from Purchase W/O");
        status t2 = new status(2, "Receipt from Purchase Order");
        status t3 = new status(3, "Receipt from Returns");
        status t4 = new status(4, "Issuance from other Branch");
        status t5 = new status(5, "Other Receipt");
        datas.add(t1);
        datas.add(t2);
        datas.add(t3);
        datas.add(t4);
        datas.add(t5);
        return datas;
    }

    public static List<status> service_type() {
        List<status> datas = new ArrayList();
        status t1 = new status(1, "Service");
        status t2 = new status(2, "Receipt from Purchase Order");
        status t3 = new status(3, "Receipt from Returns");
        datas.add(t1);
        datas.add(t2);
        datas.add(t3);
        return datas;
    }

    public static List<status> account_types() {
        List<status> datas = new ArrayList();
        status t1 = new status(1, "Administrator");
        status t2 = new status(2, "Accounting");
        status t3 = new status(3, "Inventory");
        status t4 = new status(4, "Services");
        status t5 = new status(5, "Sales");
        datas.add(t1);
        datas.add(t2);
        datas.add(t3);
        datas.add(t4);
        datas.add(t5);
        return datas;
    }

    public static List<status> payment_types() {
        List<status> datas = new ArrayList();
        status t1 = new status(1, "Cash");
        status t2 = new status(2, "Charge");
        datas.add(t1);
        datas.add(t2);
        return datas;
    }
}
