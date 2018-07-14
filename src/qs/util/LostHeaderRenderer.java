/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Guinness
 */
public class LostHeaderRenderer extends JLabel implements TableCellRenderer {

    public LostHeaderRenderer() {
        setFont(new Font("TAHOMA", 0, 16));
        setOpaque(true);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(237, 237, 237)));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 3) {
            setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            setText(value.toString() + " ");
        } else {
            setText(" " + value.toString());
        }
        return this;
    }
}
