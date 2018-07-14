/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.Window;

/**
 *
 * @author Ronald
 */
public class MyLoader {

    public static Loader d = new Loader();

    public static void load(Window p) {
        d.create(p, true);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

    public static void close() {
        d.dispose();
    }
}
