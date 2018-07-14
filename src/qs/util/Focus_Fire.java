/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Maytopacka
 */
public class Focus_Fire {

    public static void onFocus_lostFocus(JTextField[] tf) {
        for (final JTextField t : tf) {
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 153));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                }
            });
        }
    }

    public static void onFocus_lostFocus(JTextArea[] tf) {
        for (final JTextArea t : tf) {
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 153));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                }
            });
        }
    }

    public static void nextFocus(JTextField tf, final JTextField tf2) {
        tf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf2.grabFocus();
            }
        });
    }

    public static void hover(JLabel[] tf) {
        for (final JLabel t : tf) {
            t.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    t.setBackground(new java.awt.Color(102, 102, 102));
                    t.setForeground(new java.awt.Color(0, 0, 0));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                    t.setForeground(new java.awt.Color(153, 153, 153));
                }
            });
        }
    }

    public static void hover2(JLabel[] tf) {
        for (final JLabel t : tf) {
            t.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    t.setBackground(new java.awt.Color(230, 227, 227));
                    t.setForeground(new java.awt.Color(0, 0, 0));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                    t.setForeground(new java.awt.Color(153, 153, 153));
                }
            });
        }
    }

    public static void select_all(JTextField[] tf) {
        for (final JTextField t : tf) {
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {
                    t.selectAll();
                }

                @Override
                public void focusLost(FocusEvent fe) {

                }
            });
        }
    }

    public static void select_all(JTextArea[] tf) {
        for (final JTextArea t : tf) {
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {
                    t.selectAll();
                }

                @Override
                public void focusLost(FocusEvent fe) {

                }
            });
            t.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_TAB) {
                        t.transferFocus();
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }
    }

    public static void init_disable(JTextField[] tf) {
        for (final JTextField t : tf) {
            t.enable(false);
        }
    }

    public static void nextFocus2(final JTextField[] tf) {

        int i = 0;
        for (JTextField tf1 : tf) {
            final int l = i;
            if (i != tf.length - 1) {
                tf[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tf[l + 1].grabFocus();
                    }
                });
            }
            i++;
        }

    }
}
