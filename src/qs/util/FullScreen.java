/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Dummy
 */
public class FullScreen {

    public static void do_maximize_opengl(JFrame j) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices(); // There may be more than one screen-device  

        // Can also get the default-screen directly with ge.getDefaultScreenDevice()  
//        window = new Window(); // Instantiating the class from above, to create a dummy-window  
        // Setting device to full-screen  
//        j.setUndecorated(true);
        gs[0].setFullScreenWindow(j); // In 
//        gs[0].setDisplayMode(new DisplayMode);
    }

    public static void do_max_normal(JFrame frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        frame.setSize(xSize, ySize);
//        Center.setCenter(frame);
        
        frame.setVisible(true);
    }

    public static void do_max_normal(JDialog frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        frame.setVisible(true);
        frame.setSize(xSize, ySize);
//        Center.setCenter(frame);


    }

    public static void center_to_frame(JComponent parent, JDialog child) {
        Point location = parent.getLocationOnScreen();
        int x = location.x;
        int y = location.y;
        child.setLocation(x, y);
        child.setLocationRelativeTo(parent);
        child.setVisible(true);
    }
//     public static void center_to_frame(JComponent parent,JPopup child){
//   Point location = parent.getLocationOnScreen();
//   int x = location.x;
//   int y = location.y;
//   child.setLocation(x, y);
//   child.setLocationRelativeTo(parent);
//   child.setVisible(true);
//    }
}
