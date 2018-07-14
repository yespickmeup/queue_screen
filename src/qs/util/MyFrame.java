/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ronald
 */
public class MyFrame {

    public static void set(JPanel pnl, JDesktopPane pane, String title) {

        Dimension d = pane.getSize();
        int width = d.width;
        int height = d.height;
        final JInternalFrame p22 = new JInternalFrame(title, true, true, true, true);
        p22.add(pnl);
        p22.setSize(width, height);
//        p22.setFrameIcon(new ImageIcon(pane.getClass().getResource("/POS/img_menu/stock_status.png")));
        try {
            if (p22.isVisible()) {
                pane.remove(p22);
                pane.add(p22);
                p22.
                        setLocation(pane.getWidth() / 2 - p22.getWidth() / 2, pane.
                                getHeight() / 2 - p22.getHeight() / 2);
                p22.moveToFront();
                p22.setSelected(true);
                p22.show();
                pane.repaint();
            } else {
                pane.add(p22);
                p22.setLocation(pane.getWidth() / 2 - p22.getWidth() / 2, pane.getHeight() / 2 - p22.getHeight() / 2);
                p22.show();
            }

            p22.setResizable(true);
            p22.setSelected(true);
            p22.setMaximum(true);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static void set2(JPanel pnl, JDesktopPane pane, String title, int width, int height) {

        Dimension d = pane.getSize();

        final JInternalFrame p22 = new JInternalFrame(title, true, true, true, true);
        p22.add(pnl);
        p22.setSize(width, height);
//        p22.setFrameIcon(new ImageIcon(pane.getClass().getResource("/POS/img_menu/stock_status.png")));
        try {
            if (p22.isVisible()) {
                pane.remove(p22);
                pane.add(p22);
                p22.
                        setLocation(pane.getWidth() / 2 - p22.getWidth() / 2, pane.
                                getHeight() / 2 - p22.getHeight() / 2);
                p22.moveToFront();
                p22.setSelected(true);
                p22.show();
                pane.repaint();
            } else {
                pane.add(p22);
                p22.setLocation(pane.getWidth() / 2 - p22.getWidth() / 2, pane.getHeight() / 2 - p22.getHeight() / 2);
                p22.show();
            }

            p22.setResizable(true);
            p22.setSelected(true);
//            p22.setMaximum(true);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
    static int time = 0;
    static int widths = 0;
    static int heights = 0;
    static int pnl_width = 0;
    static Timer ti = null;

    public static void collapse(boolean collapse, final JPanel pnl_main, final JPanel pnl_holder, final JPanel pnl_support) {

        if (collapse) {
            if (!pnl_main.isVisible()) {
                pnl_main.setVisible(true);
            }
            widths = pnl_holder.getWidth();
            heights = pnl_holder.getHeight();
            pnl_width = pnl_main.getWidth();
//            System.out.println("Total Width: " + widths);
//            System.out.println("My Width: " + pnl_width);
            int difference = widths - pnl_width;
            final int dividend = difference / 10;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    ti = new Timer(10, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pnl_width += dividend;
                            if (pnl_width >= widths) {
                                pnl_width = pnl_main.getWidth();
                                pnl_support.setVisible(false);
                                ti.stop();
                            }
//                            System.out.println("New Width: " + pnl_width + " + " + dividend);
                            pnl_main.setMinimumSize(new Dimension(pnl_width, heights));
                            pnl_holder.updateUI();

                        }
                    });
                    ti.start();
                }
            });
            t.start();
        } else {
            widths = 0;
            heights = pnl_holder.getHeight();
            pnl_width = pnl_main.getWidth();
            if (!pnl_support.isVisible()) {
                pnl_support.setVisible(true);
            }
//            System.out.println("Total Width: " + widths);
//            System.out.println("My Width: " + pnl_width);
            int difference = widths + pnl_width;

            final int dividend = difference / 10;

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    ti = new Timer(10, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pnl_width -= dividend;
                            if (pnl_width <= widths && pnl_width <= 0) {
                                pnl_width = pnl_main.getWidth();
                                pnl_main.setVisible(false);
                                ti.stop();
                            }
//                            System.out.println("New Width: " + pnl_width + " + " + dividend);

                            pnl_main.setMinimumSize(new Dimension(pnl_width, heights));
                            pnl_holder.updateUI();

                        }
                    });
                    ti.start();
                }
            });
            t.start();
        }

    }
}
