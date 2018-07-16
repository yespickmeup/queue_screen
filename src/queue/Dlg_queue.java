/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import qs.announcements.Announcements;
import qs.counters.Counters;
import qs.queues.Queues;
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
public class Dlg_queue extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_queue
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
    private Dlg_queue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_queue(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_queue() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_queue myRef;

    private void setThisRef(Dlg_queue myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_queue> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_queue create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_queue create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_queue dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_queue((java.awt.Frame) parent, false);
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
            Dlg_queue dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_queue((java.awt.Dialog) parent, false);
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

        Dlg_queue dialog = Dlg_queue.create(new javax.swing.JFrame(), true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 130, 191));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(18, 115, 172));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Queing System");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sibulan Water District");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/linq_logo_small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(231, 231, 231));
        jPanel12.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel21.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel6.setBackground(new java.awt.Color(25, 130, 191));
        jPanel6.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Counter");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(231, 231, 231));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel19.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel22.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel20.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel18.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel8.setBackground(new java.awt.Color(231, 231, 231));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel17.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setMinimumSize(new java.awt.Dimension(250, 0));
        jLabel17.setPreferredSize(new java.awt.Dimension(0, 63));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel15.setBackground(new java.awt.Color(25, 130, 191));
        jPanel15.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Customer");
        jLabel24.setPreferredSize(new java.awt.Dimension(87, 63));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel16.setBackground(new java.awt.Color(231, 231, 231));
        jPanel16.setPreferredSize(new java.awt.Dimension(0, 63));

        jLabel26.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setMinimumSize(new java.awt.Dimension(250, 0));
        jLabel26.setPreferredSize(new java.awt.Dimension(0, 63));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel29.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(147, 147, 147))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel18.setBackground(new java.awt.Color(231, 231, 231));
        jPanel18.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel32.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel35.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel20.setBackground(new java.awt.Color(231, 231, 231));
        jPanel20.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel38.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(119, 63));

        jLabel41.setFont(new java.awt.Font("AXIS Extra Bold", 1, 40)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setMinimumSize(new java.awt.Dimension(250, 0));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 223, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 223, Short.MAX_VALUE))
                .addGap(3, 3, 3))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setMaximumSize(new java.awt.Dimension(536, 94));
        jPanel24.setMinimumSize(new java.awt.Dimension(536, 94));
        jPanel24.setPreferredSize(new java.awt.Dimension(536, 94));

        jLabel42.setFont(new java.awt.Font("AXIS Extra Bold", 0, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(97, 6, 34));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setPreferredSize(new java.awt.Dimension(0, 63));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setMinimumSize(new java.awt.Dimension(0, 172));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        init_key();
        jLabel4.setText(System.getProperty("business_name", ""));
        setSize();
//        start_server();
//        ret_queue();
//        start_server2();
        ret_counters();
        ret_announcements();
        set_time();

    }

    public void set_font() {
        String font = System.getProperty("font_size", "large");
        if (font.equalsIgnoreCase("small")) {
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/linq_logo_small.png")));
            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
            jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 20));
            jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 0, 20));
            jLabel42.setFont(new java.awt.Font("AXIS Extra Bold", 0, 16));
            cn_font(40);
        }
        if (font.equalsIgnoreCase("medium")) {
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/linq_logo_medium.png")));
            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 26));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20));
            jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 40));
            jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 0, 40));
            jLabel42.setFont(new java.awt.Font("AXIS Extra Bold", 0, 26));
            cn_font(60);
        }
        if (font.equalsIgnoreCase("large")) {
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/linq_logo_large.png")));
            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30));
            jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 60));
            jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 0, 60));
            jLabel42.setFont(new java.awt.Font("AXIS Extra Bold", 0, 36));
            cn_font(60);
        }
        if (font.equalsIgnoreCase("xl")) {
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/linq_logo_xl.png")));
            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 46));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 40));
            jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 60));
            jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 0, 60));
            jLabel42.setFont(new java.awt.Font("AXIS Extra Bold", 0, 46));
            cn_font(60);
        }
    }

    private void cn_font(int font) {
        jLabel17.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel18.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel19.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel20.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel21.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel22.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));

        jLabel26.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel29.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel32.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel35.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel38.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
        jLabel41.setFont(new java.awt.Font("AXIS Extra Bold", 1, font));
    }

    private void set_time() {
        Timer timer = new Timer("Display Timer");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Task to be executed every second

                DateFormat timeFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss aa");
                Calendar cali = Calendar.getInstance();
                cali.getTime();
                String time = timeFormat.format(cali.getTimeInMillis());

                jLabel42.setText(time + "                        ");

            }
        };

        // This will invoke the timer every second
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    //<editor-fold defaultstate="collapsed" desc=" announcements ">
    private void ret_announcements() {
        List<Announcements.to_announcements> announcements = Announcements.ret_data("order by id desc ");
        String s = "";
        for (Announcements.to_announcements a : announcements) {
            s = s + " " + a.announcement;
        }

        String font = System.getProperty("font_size", "small");
        int size = 0;
        if (font.equalsIgnoreCase("small")) {
            size = 15;
        }
        if (font.equalsIgnoreCase("medium")) {
            size = 20;
        }
        if (font.equalsIgnoreCase("large")) {
            size = 30;
        }
        if (font.equalsIgnoreCase("xl")) {
            size = 40;
        }
        MarqueeLabel myLable = new MarqueeLabel(s, MarqueeLabel.RIGHT_TO_LEFT, 10);

        myLable.setFont(new Font("Serif", Font.BOLD, size));
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(myLable);
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
    //</editor-fold>

    private void ret_counters() {
        List<Counters.to_counters> counters = Counters.ret_data("");
        JLabel[] lbls = {jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22};
        try {
            int i = 0;
            for (JLabel lbl : lbls) {
                Counters.to_counters counter = counters.get(i);
                lbl.setText(counter.counter);
                lbl.setForeground(new java.awt.Color(153, 153, 153));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

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

    private void ret_queue() {
        String where = " where status=0  and teller IS NOT NULL order by id asc ";
        List<Queues.to_queues> q = Queues.ret_data(where);
    }

    public void setSize() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());

        // Left panel
        int l_height = jPanel4.getHeight();
        double width_left = xSize * 0.3;
        double width_right = xSize * 0.7;
        jPanel4.setPreferredSize(new Dimension(FitIn.toInt("" + width_left), l_height));
        jPanel22.setPreferredSize(new Dimension((FitIn.toInt("" + width_left) / 2), l_height));
        jPanel5.setPreferredSize(new Dimension((FitIn.toInt("" + width_left) / 2), l_height));

        //Right panel
        int r_height = jPanel23.getHeight();

        System.out.println("xSize: " + xSize);
        jPanel23.setPreferredSize(new Dimension(FitIn.toInt("" + width_right), r_height));

        //set label height
        int label_height = jPanel4.getHeight();
        double label_h = label_height / 7;
        JPanel[] pnl_l = {jPanel6, jPanel9, jPanel13, jPanel11, jPanel7, jPanel8, jPanel12};
        for (JPanel pnl : pnl_l) {
            pnl.setPreferredSize(new Dimension(pnl.getWidth(), FitIn.toInt("" + label_h)));
        }
        JPanel[] pnl_r = {jPanel15, jPanel16, jPanel17, jPanel18, jPanel19, jPanel20, jPanel21};
        for (JPanel pnl : pnl_r) {
            pnl.setPreferredSize(new Dimension(pnl.getWidth(), FitIn.toInt("" + label_h)));
        }

        int height = jPanel13.getHeight() + 43;
        int width = jPanel24.getWidth();
        jPanel24.setPreferredSize(new Dimension(width, height));
        jPanel25.setPreferredSize(new Dimension(jPanel25.getWidth(), FitIn.toInt("" + l_height)));

//        set_lib();
//        jPanel28.setMaximumSize(new Dimension(14, jPanel28.getHeight()));
//        jPanel28.setPreferredSize(new Dimension(14, jPanel28.getHeight()));
//        jPanel28.setMinimumSize(new Dimension(14, jPanel28.getHeight()));
//        jPanel28.setPreferredSize(new Dimension(20, jPanel28.getHeight()));
//        jPanel28.setMaximumSize(new Dimension(20, jPanel28.getHeight()));
//        jPanel28.setMinimumSize(new Dimension(20, jPanel28.getHeight()));
//        set_player();
    }

    public void do_pass() {

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
                if (listenerSocket != null) {
                    try {
                        listenerSocket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Dlg_queue.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                disposed();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F11, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayer.mute();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F12, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play_audio("1", "1");
            }
        });

    }
    // </editor-fold>

    MediaPlayerFactory mediaPlayerFactory = null;
    EmbeddedMediaPlayer mediaPlayer = null;

    public void set_player() {

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);

        mediaPlayerFactory = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);

        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(videoSurface);
//        System.out.println("Volume: "+mediaPlayer.getVolume());
//        mediaPlayer.setVolume(1);
        mediaPlayer.enableMarquee(true);
        mediaPlayer.setFullScreen(true);

        MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();
        mediaListPlayer.setMediaPlayer(mediaPlayer); // <--- Important, associate the media player with the media list player

        jPanel10.setLayout(new BorderLayout());
//        jPanel10.setSize(jPanel25.getWidth(), jPanel25.getHeight());
        jPanel10.add(canvas, BorderLayout.CENTER);

        MediaList mediaList = mediaPlayerFactory.newMediaList();
        String[] options = {};
        String home = System.getProperty("user.home");

        home = home + "\\rsc_queue\\movies\\";
        System.out.println("home: " + home);
        File[] files = new File(home).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                mediaList.addMedia(home + file.getName(), options);
            }
        }

        mediaListPlayer.setMediaList(mediaList);

        mediaListPlayer.setMode(MediaListPlayerMode.LOOP);

        mediaListPlayer.play();

    }

    //<editor-fold defaultstate="collapsed" desc=" Server ">
    ServerSocket listenerSocket = null;
    private static final int PORT = 1000;
    private static final HashSet<String> names = new HashSet();
    private static final HashSet<PrintWriter> writers = new HashSet();

    private void start_server() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String queue_server_ip = System.getProperty("queue_server_ip", "192.168.1.152");
                    int queue_server_port = FitIn.toInt(System.getProperty("queue_server_port", "2000"));

                    if (listenerSocket == null) {
                        listenerSocket = new ServerSocket(queue_server_port);
                        new Handler(listenerSocket.accept()).start();
                    } else {
                        listenerSocket.setReuseAddress(true);

                    }
                    System.out.println("Server is up and running at port: " + queue_server_port);
                } catch (IOException ex) {
                    Logger.getLogger(Dlg_queue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    private class Handler extends Thread {

        private String name;
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {

                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED");
                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
//                    System.out.println("input: " + input);
                    String message = input.replaceAll("\n", "<n>");
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE%" + name + "%" + message);
                    }
                    System.out.println("Message: " + message);
                    String[] msg = message.split(",");
                    String counter_no = msg[0];
                    String queue_no = msg[1];
                    String type = msg[2];

                    JLabel[] counters = {jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22};
                    JLabel[] queues = {jLabel26, jLabel29, jLabel32, jLabel35, jLabel38, jLabel41};
                    int iii = 0;
                    for (int ii = 0; ii < counters.length; ii++) {
                        if (counters[ii].getText().equalsIgnoreCase(counter_no)) {
                            iii = ii;
                            break;
                        }
                    }
                    if (type.equals("1") || type.equals("2")) {
                        queues[iii].setText(queue_no);
                        queues[iii].setForeground(new java.awt.Color(0, 0, 0));
                        counters[iii].setForeground(new java.awt.Color(0, 0, 0));
                        animateLabel(counters[iii], queues[iii], type);
                        play_audio(counter_no, queue_no);
                    } else {
                        animateLabel_hide(counters[iii], queues[iii], type);
                    }

                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {

                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private void animateLabel_hide(JLabel lbl1, JLabel lbl2, String type) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    private int i = 0;

                    public void run() {
                        if (i == 2) {
                            timer.cancel();
                            timer.purge();

                        }
                        if (i == 1) {
                            lbl1.setForeground(new java.awt.Color(153, 153, 153));
                            lbl2.setForeground(new java.awt.Color(255, 255, 255));

                            lbl1.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize()));
                            lbl2.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize()));

                            lbl2.setText("");
                        }

                        i++;
                    }
                };
                timer.scheduleAtFixedRate(task, 0, 1000); //1000ms = 1sec

                jPanel4.updateUI();
            }
        });
        t.start();
    }

    private void animateLabel(JLabel lbl1, JLabel lbl2, String type) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    private int i = 0;

                    public void run() {
                        if (i == 5) {
                            timer.cancel();
                            timer.purge();

                        }
                        if (i == 1) {
                            if (type.equals("1")) {
                                lbl1.setForeground(new java.awt.Color(0, 51, 255));
                                lbl2.setForeground(new java.awt.Color(0, 51, 255));
                            }
                            if (type.equals("2")) {
                                lbl1.setForeground(new java.awt.Color(204, 0, 0));
                                lbl2.setForeground(new java.awt.Color(204, 0, 0));
                            }
                            lbl1.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize() + 10));
                            lbl2.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl2.getFont().getSize() + 10));

                        }
                        if (i == 2) {
                            lbl1.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize() - 10));
                            lbl2.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl2.getFont().getSize() - 10));

                            lbl1.setForeground(new java.awt.Color(0, 0, 0));
                            lbl2.setForeground(new java.awt.Color(0, 0, 0));
                        }
                        if (i == 3) {
                            if (type.equals("1")) {
                                lbl1.setForeground(new java.awt.Color(0, 51, 255));
                                lbl2.setForeground(new java.awt.Color(0, 51, 255));
                            }
                            if (type.equals("2")) {
                                lbl1.setForeground(new java.awt.Color(204, 0, 0));
                                lbl2.setForeground(new java.awt.Color(204, 0, 0));
                            }
                            lbl1.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize() + 10));
                            lbl2.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl2.getFont().getSize() + 10));

                        }
                        if (i == 4) {
                            lbl1.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl1.getFont().getSize() - 10));
                            lbl2.setFont(new Font("AXIS Extra Bold", Font.BOLD, lbl2.getFont().getSize() - 10));
                            lbl1.setForeground(new java.awt.Color(0, 0, 0));
                            lbl2.setForeground(new java.awt.Color(0, 0, 0));
                        }
                        i++;
                    }
                };
                timer.scheduleAtFixedRate(task, 0, 1000); //1000ms = 1sec

                jPanel4.updateUI();
            }
        });
        t.start();
    }

    private void play_audio(String customer_no, String counter_no) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    mediaPlayer.mute();

                    String directory = System.getProperty("user.home");
                    directory = directory + "\\rsc_queue\\bell.wav";
                    File filename = new File(directory);
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(filename));
                    clip.start();

                    VoiceManager vm = VoiceManager.getInstance();
                    Voice v = vm.getVoice("mbrola_us1");
                    v.setPitchShift(1);
                    v.setPitchRange(10);
                    v.allocate();
                    v.speak("Customer Number " + counter_no + ", please proceed to counter " + customer_no);
                    v.speak("Customer Number " + counter_no + ", please proceed to counter " + customer_no);
                    mediaPlayer.mute();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Start Server 2 ">
    public void start_server2() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    String queue_server_ip = System.getProperty("queue_server_ip", "192.168.1.152");
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

                                JLabel[] counters = {jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22};
                                JLabel[] queues = {jLabel26, jLabel29, jLabel32, jLabel35, jLabel38, jLabel41};
                                int iii = 0;
                                for (int ii = 0; ii < counters.length; ii++) {
                                    if (counters[ii].getText().equalsIgnoreCase(counter_no)) {
                                        iii = ii;
                                        break;
                                    }
                                }
                                if (type.equals("1") || type.equals("2")) {
                                    queues[iii].setText(queue_no);
                                    queues[iii].setForeground(new java.awt.Color(0, 0, 0));
                                    counters[iii].setForeground(new java.awt.Color(0, 0, 0));
                                    animateLabel(counters[iii], queues[iii], type);
                                    play_audio(counter_no, queue_no);
                                } else {
                                    animateLabel_hide(counters[iii], queues[iii], type);
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
    //</editor-fold>
}
