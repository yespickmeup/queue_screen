/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

/**
 *
 * @author Guinness
 */
public class Tables {

    public static class to_serial_nos {

        public final int id;
        public final String serial_no;
        public boolean selected;

        public to_serial_nos(int id, String serial_no, boolean selected) {
            this.id = id;
            this.serial_no = serial_no;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

}
