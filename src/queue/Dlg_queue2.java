/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import qs.announcements.Announcements;
import qs.test.Dlg_test_player;
import qs.util.ExecuteShellComand;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Guinness
 */
public class Dlg_queue2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_queue2
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_queue2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_queue2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_queue2() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_queue2 myRef;

    private void setThisRef(Dlg_queue2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_queue2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_queue2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_queue2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_queue2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_queue2((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_queue2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_queue2((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Dlg_queue2 dialog = Dlg_queue2.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_queue = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_queue1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(134, 213, 246));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/bawad (Custom).png"))); // NOI18N
        jLabel5.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel6.setText("Welcome to Bayawan Water District");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Lot N, Block N. Don Gaspar Subdivision, Villareal, Bayawan City Negros Oriental");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Website: www.bawad.gov.ph | Telephone Number: (035) 430-0361");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("00:00:00 PM");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Aug 11,2018");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(new java.awt.Color(202, 219, 227));

        jScrollPane2.setBackground(new java.awt.Color(25, 130, 191));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setFocusable(false);

        jPanel8.setOpaque(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1485, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFocusable(false);

        tbl_queue.setBackground(new java.awt.Color(25, 130, 191));
        tbl_queue.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tbl_queue.setForeground(new java.awt.Color(255, 255, 255));
        tbl_queue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_queue.setFocusable(false);
        tbl_queue.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_queue.setRowHeight(70);
        tbl_queue.setSelectionForeground(new java.awt.Color(18, 115, 172));
        jScrollPane1.setViewportView(tbl_queue);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(134, 213, 246));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 33, 145));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ticket Number");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 140)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(11, 33, 145));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please proceed to");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 90)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setFocusable(false);

        tbl_queue1.setBackground(new java.awt.Color(25, 130, 191));
        tbl_queue1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        tbl_queue1.setForeground(new java.awt.Color(255, 255, 255));
        tbl_queue1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_queue1.setFocusable(false);
        tbl_queue1.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_queue1.setRowHeight(70);
        tbl_queue1.setSelectionForeground(new java.awt.Color(18, 115, 172));
        jScrollPane3.setViewportView(tbl_queue1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_queue;
    private javax.swing.JTable tbl_queue1;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_label();

        set_time();
        ret_announcements();
        Table.init_tbl_announcements(tbl_queue);
        Table.init_tbl_announcements2(tbl_queue1);

        ret_queues();

//        set_lib();
//        set_player();
    }

    public void do_pass() {
//        [14,97,146]
    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mediaListPlayer_bell.play();
            }
        });

    }
    // </editor-fold>

    private void set_label() {
        jLabel6.setText("Welcome to " + System.getProperty("business_name", "Bayawan Water District"));
        jLabel7.setText(System.getProperty("address", "Lot N, Block N. Don Gaspar Subdivision, Villareal, Bayawan City Negros Oriental"));
        jLabel8.setText(System.getProperty("contact_no", "Website: www.bawad.gov.ph | Telephone Number: (035) 430-0361"));
    }

    private void set_time() {
        Timer timer = new Timer("Display Timer");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
        DateFormat timeFormat2 = new SimpleDateFormat("MMM dd,yyyy");
        jLabel10.setText(timeFormat2.format(new Date()));

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        // Task to be executed every second

                        Calendar cali = Calendar.getInstance();
                        cali.getTime();
                        String time = timeFormat.format(cali.getTimeInMillis());

                        jLabel9.setText(time);

                    }
                };

                // This will invoke the timer every second
                timer.scheduleAtFixedRate(task, 1000, 1000);
            }
        });
        t1.start();

    }

    private void ret_announcements() {
        List<Announcements.to_announcements> announcements = Announcements.ret_data("order by id desc ");
        String s = "";
        for (Announcements.to_announcements a : announcements) {
            s = s + " " + a.announcement;
        }

        final String ss = s;
        jPanel8.setLayout(new BorderLayout());
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.getViewport().setBorder(null);
        jScrollPane2.setViewportBorder(null);
        jScrollPane2.setBorder(null);
//        jPanel8.setMaximumSize(new Dimension(jPanel3.getWidth() - 100, jPanel3.getHeight() - 10));
//        jPanel8.setMinimumSize(new Dimension(jPanel3.getWidth() - 100, jPanel3.getHeight() - 10));
//        jPanel8.setPreferredSize(new Dimension(jPanel3.getWidth() - 100, jPanel3.getHeight() - 10));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dlg_queue.MarqueeLabel myLable = new Dlg_queue.MarqueeLabel(ss, Dlg_queue2.MarqueeLabel.RIGHT_TO_LEFT, 10);
                myLable.setFont(new Font("Serif", Font.BOLD, 50));
                myLable.setForeground(new java.awt.Color(204, 0, 0));

                jPanel8.add(myLable);
                jPanel8.updateUI();
            }
        });

//        Thread t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//            }
//        });
//        t.start();
    }

    public static class MarqueeLabel extends JLabel {

        public static int LEFT_TO_RIGHT = 1;
        public static int RIGHT_TO_LEFT = 2;
        String text;
        int Option;
        int Speed;

        public MarqueeLabel(String text, int Option, int Speed) {
            this.Option = Option;
            this.Speed = Speed;
            this.setText(text);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (Option == LEFT_TO_RIGHT) {
                g.translate((int) ((System.currentTimeMillis() / Speed) % (getWidth() * 2) - getWidth()), 0);
            } else if (Option == RIGHT_TO_LEFT) {
                g.translate((int) (getWidth() - (System.currentTimeMillis() / Speed) % (getWidth() * 2)), 0);
            }

            super.paintComponent(g);
            super.updateUI();
//            repaint(10);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" degrees "> 
    public static class queue {

        int id;
        String customer_no;
        String counter_no;

        public queue() {
        }

        public queue(int id, String customer_no, String counter_no) {
            this.id = id;
            this.customer_no = customer_no;
            this.counter_no = counter_no;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomer_no() {
            return customer_no;
        }

        public void setCustomer_no(String customer_no) {
            this.customer_no = customer_no;
        }

        public String getCounter_no() {
            return counter_no;
        }

        public void setCounter_no(String counter_no) {
            this.counter_no = counter_no;
        }

    }

    private void ret_queues() {
        String where = "";

        List<queue> qs = new ArrayList();
        List<queue> qs2 = new ArrayList();
        queue q1 = new queue(1, "A1", "1");
        queue q2 = new queue(2, "A2", "2");
        queue q3 = new queue(3, "A3", "3");
        queue q4 = new queue(4, "A4", "4");
        queue q5 = new queue(5, "A5", "5");
        queue q6 = new queue(6, "A6", "6");

        qs.add(q1);
        qs.add(q2);
        qs.add(q3);
        qs2.add(q4);
        qs2.add(q5);
        qs2.add(q6);
        Table.loadData_announcements(qs);
        Table.loadData_announcements2(qs2);
    }

    //<editor-fold defaultstate="collapsed" desc=" Video ">
    public void set_lib() {
        System.setProperty("mbrola.base", "mbrola");

        String VLC_PLUGIN_PATH = System.getProperty("VLC_PLUGIN_PATH", "C:\\Program Files\\VideoLAN\\VLC\\plugins");
        String VLC_PLUGIN_NATIVE_PATH = System.getProperty("VLC_PLUGIN_NATIVE_PATH", "C:\\Program Files\\VideoLAN\\VLC");

        System.out.println("VLC_PLUGIN_PATH: " + VLC_PLUGIN_PATH);
        System.out.println("VLC_PLUGIN_NATIVE_PATH: " + VLC_PLUGIN_NATIVE_PATH);
        System.setProperty("VLC_PLUGIN_PATH", VLC_PLUGIN_PATH);

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), VLC_PLUGIN_NATIVE_PATH);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }

    MediaPlayerFactory mediaPlayerFactory = null;
    EmbeddedMediaPlayer mediaPlayer = null;
    int play_sound = 1;

    MediaPlayerFactory factory_bell = null;
    MediaListPlayer mediaListPlayer_bell = null;
    MediaList playList_bell = null;

    public void set_player() {

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);
        String[] VLC_ARGS = { //            "--intf", "dummy", // no interface
        //            "--vout", "dummy", // we don't want video (output)
        //            "--no-audio", // we don't want audio (decoding)
        //            "--no-video-title-show", // nor the filename displayed
        //            "--no-stats", // no stats
        //            "--no-sub-autodetect-file", // we don't want subtitles
        //            "--no-inhibit", // we don't want interfaces
        //            "--no-disable-screensaver", // we don't want interfaces
        //            "--no-snapshot-preview", // no blending in dummy vout
        };
        mediaPlayerFactory = new MediaPlayerFactory();

        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);

//        HeadlessMediaPlayer mediaPlayer2 = mediaPlayerFactory.newHeadlessMediaPlayer();
        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

        mediaPlayer.setVideoSurface(videoSurface);
//        System.out.println("Volume: "+mediaPlayer.getVolume());
//        mediaPlayer.setVolume(1);
        mediaPlayer.enableMarquee(true);
        mediaPlayer.setFullScreen(true);

        MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();

        mediaListPlayer.setMediaPlayer(mediaPlayer); // <--- Important, associate the media player with the media list player

        jPanel6.setLayout(new BorderLayout());
//        jPanel10.setSize(jPanel25.getWidth(), jPanel25.getHeight());
        jPanel6.add(canvas, BorderLayout.CENTER);

        MediaList mediaList = mediaPlayerFactory.newMediaList();

        String[] options = {};
        String home = System.getProperty("user.home");

        home = home + "\\rsc_queue\\movies\\";
        System.out.println("home: " + home);
        File[] files = new File(home).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                mediaList.addMedia(home + file.getName(), VLC_ARGS);

            }
        }

        mediaListPlayer.setMediaList(mediaList);

        mediaListPlayer.setMode(MediaListPlayerMode.LOOP);

        mediaListPlayer.play();

        factory_bell = new MediaPlayerFactory();
        mediaListPlayer_bell = factory_bell.newMediaListPlayer();
        playList_bell = factory_bell.newMediaList();

        String directory = System.getProperty("user.home");
        directory = directory + "\\rsc_queue\\bell.wav";
        playList_bell.addMedia(directory, options);
        mediaListPlayer_bell.setMode(MediaListPlayerMode.DEFAULT);
        mediaListPlayer_bell.setMediaList(playList_bell);

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Start Server 2 ">
    public void start_server2() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int queue_server_port = FitIn.toInt(System.getProperty("queue_server_port", "2000"));
                    System.out.println("Starting Server...");
                    ServerSocket listener = new ServerSocket(queue_server_port);
                    try {
                        while (true) {
                            java.net.Socket socket = listener.accept();
                            try {
                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
                                String input = in.readLine();

                                String message = input.replaceAll("\n", "<n>");
                                String[] msg = message.split(",");
                                String counter_no = msg[0];
                                String queue_no = msg[1];
                                String type = msg[2];

                                if (type.equals("1") || type.equals("2")) {
//                                    init_call(counter_no, queue_no);
                                    ExecutorService pool = Executors.newFixedThreadPool(1);
                                    try {
                                        pool.submit(new One()).get();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Dlg_test_player.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ExecutionException ex) {
                                        Logger.getLogger(Dlg_test_player.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                } else {
                                    jLabel1.setText("");
                                    jLabel1.setText("");
                                }
                            } finally {
                                socket.close();
                            }
                        }
                    } finally {
                        listener.close();
                    }
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        });
        t.start();

    }

    Thread t = null;

    private void init_call(String counter_no, String queue_no) {

        final String espeak_version = System.getProperty("espeak_version", "");
        final String espeak_gender = System.getProperty("espeak_gender", "");
        final String espeak_speed = System.getProperty("espeak_speed", "");
        final String espeak_amplitude = System.getProperty("espeak_amplitude", "");
        final String espeak_pitch = System.getProperty("espeak_pitch", "");

        t = new Thread(new Runnable() {

            @Override
            public void run() {

                String stmt = counter_no;
                if (stmt.length() == 2) {
                    String s1 = stmt.substring(0, 1);
                    if (s1.equalsIgnoreCase("0")) {
                        stmt = stmt.substring(1, 2);
                    }
                }
                jLabel1.setText(queue_no);
                jLabel4.setText("Counter " + stmt);
                String stmt2 = stmt;
                mediaListPlayer_bell.play();
                ExecuteShellComand cmd = new ExecuteShellComand();
                String q1 = queue_no.substring(0, 1);
                String q2 = queue_no.substring(1, queue_no.length());

                String command = " espeak -v" + espeak_version + espeak_gender + " " + "-s" + espeak_speed + " -a" + espeak_amplitude + " -p" + espeak_pitch + " \"             Now Serving, Ticket number. " + q1 + "--" + q2 + ". Please Proceed to Counter " + stmt2 + ".";
                String output = cmd.executeCommand(command);
                String output2 = cmd.executeCommand(command);
//                try {
//                    SwingUtilities.invokeLater(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            try {
//
//                                if (play_sound == 1) {
//                                    mediaPlayer.mute();
//                                }
//                                //Play Mp3
//
////                                String directory = System.getProperty("user.home");
////                                directory = directory + "\\rsc_queue\\bell.wav";
////                                File filename = new File(directory);
////                                Clip clip = AudioSystem.getClip();
////                                clip.open(AudioSystem.getAudioInputStream(filename));
////                                clip.start();
//                                //Voice
////                              
//                                if (play_sound == 1) {
//                                    mediaPlayer.mute();
//                                }
////                                VoiceManager vm = VoiceManager.getInstance();
////                                Voice v = vm.getVoice("mbrola_us1");
////                                v.setDurationStretch(1);//set slow/fast talking
////                                v.setPitchRange(30); //30-normal
////                                v.allocate();
////                                v.speak("Customer Number " + counter_no + "... please proceed to counter " + customer_no + "...");
////                                v.speak("Customer Number " + counter_no + "... please proceed to counter " + customer_no + "...");
//
//                            } catch (Exception e) {
//                                System.out.println(e);
//                            }
//                        }
//                    });
//
//                } catch (Exception e) {
//                    System.out.println(e);
//                }

            }
        });
        if (t.isAlive()) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            t.start();
        }

    }
    //</editor-fold>

    public class One implements Callable<Integer> {

        public One() {
        }

        @Override
        public Integer call() throws Exception {
            if (play_sound == 1) {
                mediaPlayer.mute();
            }
            String counter_no = "01";
            String queue_no = "A1";
            final String espeak_version = System.getProperty("espeak_version", "");
            final String espeak_gender = System.getProperty("espeak_gender", "");
            final String espeak_speed = System.getProperty("espeak_speed", "");
            final String espeak_amplitude = System.getProperty("espeak_amplitude", "");
            final String espeak_pitch = System.getProperty("espeak_pitch", "");

            String stmt = counter_no;
            if (stmt.length() == 2) {
                String s1 = stmt.substring(0, 1);
                if (s1.equalsIgnoreCase("0")) {
                    stmt = stmt.substring(1, 2);
                }
            }
            jLabel1.setText(queue_no);
            jLabel4.setText("Counter " + stmt);
            String stmt2 = stmt;
            mediaListPlayer_bell.play();
            ExecuteShellComand cmd = new ExecuteShellComand();
            String q1 = queue_no.substring(0, 1);
            String q2 = queue_no.substring(1, queue_no.length());
            System.out.println("q1: "+q1);
            String command = " espeak -v" + espeak_version + espeak_gender + " " + "-s" + espeak_speed + " -a" + espeak_amplitude + " -p" + espeak_pitch + " \"             Now Serving, Ticket number. " + q1 + "-" + q2 + ". Please Proceed to Counter " + stmt2 + ".";
            System.out.println(command);
            String output = cmd.executeCommand(command);
            String output2 = cmd.executeCommand(command);

            if (play_sound == 1) {
                mediaPlayer.mute();
            }
            return 1;

        }
    }
}
