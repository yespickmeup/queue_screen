/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class Table {

    public static ArrayListModel tbl_degrees_ALM;
    public static TbldegreesModel tbl_degrees_M;

    public static void init_tbl_announcements(JTable tbl_degrees) {
        tbl_degrees_ALM = new ArrayListModel();
        tbl_degrees_M = new TbldegreesModel(tbl_degrees_ALM);
        tbl_degrees.setModel(tbl_degrees_M);
        tbl_degrees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_degrees.setRowHeight(25);
        int[] tbl_widths_degrees = {100};
        for (int i = 0, n = tbl_widths_degrees.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_degrees, i, tbl_widths_degrees[i]);
        }
        Dimension d = tbl_degrees.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_degrees.getTableHeader().setPreferredSize(d);
        tbl_degrees.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_degrees.setRowHeight(100);
//        tbl_degrees.setFont(new java.awt.Font("Tahoma", 0, 1));

        TableColumnModel tcm = tbl_degrees.getColumnModel();
        TableColumn tm = tcm.getColumn(0);
        tm.setCellRenderer(new MultiLabelRenderer());
    }

    static class Html extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            JLabel lbl = new JLabel();
            lbl.setText(value.toString());
            lbl.setOpaque(true);
            lbl.setBackground(Color.white);
            if (selected) {
                lbl.setBackground(new java.awt.Color(4, 176, 217));
                lbl.setForeground(new java.awt.Color(0, 0, 0));
            }
            return lbl;
        }
    }

    public static void loadData_announcements(List<Dlg_queue2.queue> acc) {
        tbl_degrees_ALM.clear();
        tbl_degrees_ALM.addAll(acc);
    }

    public static class TbldegreesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            ""
        };

        public TbldegreesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Dlg_queue2.queue tt = (Dlg_queue2.queue) getRow(row);
            switch (col) {
                case 0:

                    return "" + tt.customer_no
                            + "," + tt.counter_no;

                default:
                    return "";
            }
        }

    }

    public static ArrayListModel tbl_degrees_ALM2;
    public static TbldegreesModel2 tbl_degrees_M2;

    public static void init_tbl_announcements2(JTable tbl_degrees) {
        tbl_degrees_ALM2 = new ArrayListModel();
        tbl_degrees_M2 = new TbldegreesModel2(tbl_degrees_ALM2);
        tbl_degrees.setModel(tbl_degrees_M2);
        tbl_degrees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_degrees.setRowHeight(25);
        int[] tbl_widths_degrees = {100};
        for (int i = 0, n = tbl_widths_degrees.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_degrees, i, tbl_widths_degrees[i]);
        }
        Dimension d = tbl_degrees.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_degrees.getTableHeader().setPreferredSize(d);
        tbl_degrees.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_degrees.setRowHeight(100);
//        tbl_degrees.setFont(new java.awt.Font("Tahoma", 0, 1));

        TableColumnModel tcm = tbl_degrees.getColumnModel();
        TableColumn tm = tcm.getColumn(0);
        tm.setCellRenderer(new MultiLabelRenderer());
    }

    public static void loadData_announcements2(List<Dlg_queue2.queue> acc) {
        tbl_degrees_ALM2.clear();
        tbl_degrees_ALM2.addAll(acc);
    }

    public static class TbldegreesModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            ""
        };

        public TbldegreesModel2(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Dlg_queue2.queue tt = (Dlg_queue2.queue) getRow(row);
            switch (col) {
                case 0:

                    return "" + tt.customer_no
                            + "," + tt.counter_no;

                default:
                    return "";
            }
        }

    }

    public static class MultiLabelRenderer implements TableCellRenderer {

        public MultiLabelRenderer() {
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, final int row, final int column) {
            String[] val = value.toString().split(",");
            JPanel panel1 = new JPanel();
            panel1.setBackground(new java.awt.Color(15, 157, 223));
            JLabel jLabel1 = new JLabel();
            JLabel jLabel2 = new JLabel();
            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 42)); // NOI18N
            jLabel1.setText("Ticket " + val[0]);
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
            jLabel2.setText("Counter " + val[1]);
            jLabel2.setForeground(new java.awt.Color(200, 219, 226));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
            panel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                                    .addGap(5, 5, 5))
            );

            return panel1;
        }
    }
}
