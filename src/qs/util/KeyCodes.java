/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Guinness
 */
public class KeyCodes {

    public static void numpad(JComponent comp, final JLabel lbl_qty) {
        comp.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
              
                String qty = lbl_qty.getText();
                if (e.getKeyCode() == 96 || e.getKeyCode() == 48) {
                    qty = qty + "0";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 97 || e.getKeyCode() == 49) {
                    qty = qty + "1";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 98 || e.getKeyCode() == 50) {
                    qty = qty + "2";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 99 || e.getKeyCode() == 51) {
                    qty = qty + "3";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 100 || e.getKeyCode() == 52) {
                    qty = qty + "4";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 101 || e.getKeyCode() == 53) {
                    qty = qty + "5";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 102 || e.getKeyCode() == 54) {
                    qty = qty + "6";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 103 || e.getKeyCode() == 55) {
                    qty = qty + "7";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 104 || e.getKeyCode() == 56) {
                    qty = qty + "8";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 105 || e.getKeyCode() == 57) {
                    qty = qty + "9";
                    lbl_qty.setText(qty);
                }
                if (e.getKeyCode() == 110 || e.getKeyCode() == 46) {
                    qty = qty + ".";
                    lbl_qty.setText(qty);
                }

                if (e.getKeyCode() == 8) {
                    int length = lbl_qty.getText().length();
                    if (length > 0) {
                        String var = lbl_qty.getText();
                        var = var.substring(0, length - 1);
                        lbl_qty.setText(var);
                    }

                }

            }
        });
    }
}
