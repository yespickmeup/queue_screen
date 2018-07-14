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
 * @author Guinness
 */
public class CheckBox {

    public static class list {

        public final boolean selected;
        public final String stmt;

        public list(boolean selected, String stmt) {
            this.selected = selected;
            this.stmt = stmt;
        }
    }

    public static List<CheckBox.list> sample() {
        List<CheckBox.list> datas = new ArrayList();
        CheckBox.list t1 = new CheckBox.list(false, "The");
        CheckBox.list t2 = new CheckBox.list(false, "Quick");
        CheckBox.list t3 = new CheckBox.list(false, "Brown");
        CheckBox.list t4 = new CheckBox.list(false, "Fox");
        CheckBox.list t5 = new CheckBox.list(false, "Jump");
        datas.add(t1);
        datas.add(t2);
        datas.add(t3);
        datas.add(t4);
        datas.add(t5);
        return datas;
    }

}
