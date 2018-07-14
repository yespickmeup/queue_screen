/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import javax.swing.JLabel;

/**
 *
 * @author Guinness
 */
public class MyIcon {

    public static JLabel arrow_down() {
        JLabel lbl = new JLabel();
        lbl.setIcon(new javax.swing.ImageIcon(MyIcon.class.getResource("/POS/icons/1412342170_basics-08-24.png")));
        return lbl;
    }
}
