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
public class Segregator {

    public static String this_shit(String serial1, String serial2) {
        String new_serial = "";
        String[] l_serial2 = serial2.split("\n");
        for (String s1 : l_serial2) {
            if (serial1.contains(s1)) {
                serial1 = serial1.replaceAll(s1, "");
            }
        }
        String[] l_serial = serial1.split("\n");
        int i = 0;
        for (String s2 : l_serial) {
            if (!s2.equals("\n")) {
                if (i == 0) {
                    if (!s2.isEmpty()) {
                        new_serial = s2;
                    }
                } else {
                    if (!s2.isEmpty()) {
                        new_serial = new_serial + "\n" + s2;
                    }
                }
                i++;
            }
        }
        return new_serial;
    }

    public static void main(String[] args) {
        System.out.println(this_shit("1111\n2222\n3333", "2222"));
    }
}
