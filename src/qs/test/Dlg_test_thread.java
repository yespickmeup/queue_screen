/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import queue.Dlg_queue2;
import synsoftech.util.Center;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventAdapter;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Guinness
 */
public class Dlg_test_thread extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_test_thread
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
    private Dlg_test_thread(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_test_thread(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_test_thread() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_test_thread myRef;

    private void setThisRef(Dlg_test_thread myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_test_thread> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_test_thread create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_test_thread create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_test_thread dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_test_thread((java.awt.Frame) parent, false);
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
            Dlg_test_thread dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_test_thread((java.awt.Dialog) parent, false);
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

        Dlg_test_thread dialog = Dlg_test_thread.create(new javax.swing.JFrame(), true);
        Center.setCenter(dialog);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 314, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        call();
//        run();
//        run2();
//        call_number2("A1", "1");
//        runnable();
//        sync();

        test2();

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_lib();
        set_player();

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
                disposed();
            }
        });
    }
    // </editor-fold>

    Thread t1 = null;

    //<editor-fold defaultstate="collapsed" desc=" Test 1 ">
    List<Thread> threads = new ArrayList();
    ExecutorService pool = Executors.newFixedThreadPool(20);
    List<Future<String>> futures = new ArrayList<>();

    private void call() {
        Random rand = new Random();
        String queue_no = "A" + rand.nextInt(50);
        String counter_no = "1";
        call_number(counter_no, queue_no);
    }

    private void call_number(String counter_no, String queue_no) {

        try {
            t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        String directory = System.getProperty("user.home");
                        directory = directory + "\\rsc_queue\\bell.wav";
                        String stmt = counter_no;
                        if (stmt.length() == 2) {
                            String s1 = stmt.substring(0, 1);
                            if (s1.equalsIgnoreCase("0")) {
                                stmt = stmt.substring(1, 2);
                            }
                        }
                        jLabel1.setText(queue_no);
                        jLabel2.setText(stmt);
                        String stmt2 = stmt;
                        String[] options = {};
                        String bell = System.getProperty("user.home");
                        bell = bell + "\\rsc_queue\\bell.wav";
                        String directory2 = System.getProperty("user.home");
                        directory2 = directory2 + "\\rsc_queue\\voices\\";
                        String q1 = queue_no.substring(0, 1);
                        String q2 = queue_no.substring(1, queue_no.length());
                        String now_serving = directory2 + q1 + "\\" + q2 + ".wav";
                        String counter = directory2 + "counter\\" + stmt2 + ".wav";
                        File filename = new File(directory);
                        File filename2 = new File(now_serving);
                        File filename3 = new File(counter);
                        Clip clip = AudioSystem.getClip();
                        Clip clip2 = AudioSystem.getClip();
                        Clip clip3 = AudioSystem.getClip();

                        try {
                            clip.open(AudioSystem.getAudioInputStream(filename));
                            clip2.open(AudioSystem.getAudioInputStream(filename2));
                            clip3.open(AudioSystem.getAudioInputStream(filename3));
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        clip.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {
                                    clip2.start();
                                }
                            }
                        });
                        clip2.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {
                                    clip3.start();
                                }
                            }
                        });
                        clip3.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {

                                    clip.drain();
                                    clip.stop();
                                    clip.close();
                                    clip2.drain();
                                    clip2.stop();
                                    clip2.close();
                                    clip3.drain();
                                    clip3.stop();
                                    clip3.close();
                                }
                            }
                        });

                        clip.start();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            System.out.println("t1.getThreadGroup()" + t1.getThreadGroup());
            if (!t1.isAlive()) {
                t1.start();
            } else {
                t1.join(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Dlg_test_thread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void call_number2(String counter_no, String queue_no) {

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.setVolume(20);
                    mediaPlayer.mute(true);
//                    ExecuteShellComand cmd = new ExecuteShellComand();
//                    String output = cmd.executeCommand("ipconfig");
                    try {

                        String directory = System.getProperty("user.home");
                        directory = directory + "\\rsc_queue\\bell.wav";
                        String stmt = counter_no;
                        if (stmt.length() == 2) {
                            String s1 = stmt.substring(0, 1);
                            if (s1.equalsIgnoreCase("0")) {
                                stmt = stmt.substring(1, 2);
                            }
                        }
                        jLabel1.setText(queue_no);
                        jLabel2.setText(stmt);
                        String stmt2 = stmt;
                        String[] options = {};
                        String bell = System.getProperty("user.home");
                        bell = bell + "\\rsc_queue\\bell.wav";
                        String directory2 = System.getProperty("user.home");
                        directory2 = directory2 + "\\rsc_queue\\voices\\";
                        String q1 = queue_no.substring(0, 1);
                        String q2 = queue_no.substring(1, queue_no.length());
                        String now_serving = directory2 + q1 + "\\" + q2 + ".wav";
                        String counter = directory2 + "counter\\" + stmt2 + ".wav";
                        File filename = new File(directory);
                        File filename2 = new File(now_serving);
                        File filename3 = new File(counter);
                        Clip clip = AudioSystem.getClip();
                        Clip clip2 = AudioSystem.getClip();
                        Clip clip3 = AudioSystem.getClip();

                        try {
                            clip.open(AudioSystem.getAudioInputStream(filename));
                            clip2.open(AudioSystem.getAudioInputStream(filename2));
                            clip3.open(AudioSystem.getAudioInputStream(filename3));
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        clip.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {
                                    clip2.start();
                                }
                            }
                        });
                        clip2.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {
                                    clip3.start();
                                }
                            }
                        });
                        clip3.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType() == LineEvent.Type.STOP) {

                                    clip.drain();
                                    clip.stop();
                                    clip.close();
                                    clip2.drain();
                                    clip2.stop();
                                    clip2.close();
                                    clip3.drain();
                                    clip3.stop();
                                    clip3.close();
                                    mediaPlayer.setVolume(100);
                                    mediaPlayer.mute(false);
                                }
                            }
                        });

                        clip.start();

                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Dlg_queue2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        } catch (Exception e) {
        }

    }

    private void run() {
        Thread thread = new Thread(new RunnableExample());
        thread.start();
    }

    private void run2() {
        Callable<String> callable = new Summation(1, 1);

        Future<String> future = pool.submit(callable);
    }

    public class RunnableExample implements Runnable {

        @Override
        public void run() {
            Random rand = new Random();
            String queue_no = "A" + rand.nextInt(50);
            String counter_no = "1";
            call_number(counter_no, queue_no);
        }
    }

    public class Summation implements Callable<String> {

        private int a;
        private int b;

        public Summation(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String call() {
            Random rand = new Random();
            String queue_no = "A" + rand.nextInt(50);
            String counter_no = "1";
            call_number2(counter_no, queue_no);
            return "" + this.a + this.b;
        }
    }

    private void runnable() {
        Runnable myRunnable = new Runnable() {

            public void run() {

                try {
                    Random rand = new Random();
                    String queue_no = "A" + rand.nextInt(50);
                    String counter_no = "1";
                    call_number2(counter_no, queue_no);
                } catch (Exception ex) {
                }

            }
        };

        Thread thread = new Thread(myRunnable);
//        thread.start();
        threads.add(thread);
    }

    class ThreadB extends Thread {

        String counter_no;
        String queue_no;

        public ThreadB(String counter_no, String queue_no) {
            this.counter_no = counter_no;
            this.queue_no = queue_no;
        }

        @Override
        public void run() {
            synchronized (this) {

                call_number2(counter_no, queue_no);
                notify();
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Test 2 ">
    MediaPlayerFactory factory_bell = null;
    MediaListPlayer mediaListPlayer_bell = null;
    MediaList playList_bell = null;
    List<String> playlist = new ArrayList();

    private void test2() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                playList_bell.clear();

                Random rand = new Random();
                String queue_no = "A" + rand.nextInt(50);
                String counter_no = "" + rand.nextInt(10);
                playlist.add("" + queue_no + "," + counter_no);

                for (String sound : playlist) {
                    String[] s = sound.split(",");
                    queue_no = s[0];
                    counter_no = s[1];
                    if (counter_no.length() == 1) {
                        counter_no = "0" + counter_no;
                    }
                    String stmt = counter_no;
                    if (stmt.length() == 2) {
                        String s1 = stmt.substring(0, 1);
                        if (s1.equalsIgnoreCase("0")) {
                            stmt = stmt.substring(1, 2);
                        }
                    }

                    String stmt2 = stmt;

                    String directory2 = System.getProperty("user.home");
                    directory2 = directory2 + "\\rsc_queue\\voices\\";

                    String q1 = queue_no.substring(0, 1);
                    String q2 = queue_no.substring(1, queue_no.length());

                    String now_serving = directory2 + "letters\\" + q1 + "\\" + q2 + ".wav";
                    String counter = directory2 + "counter\\" + stmt2 + ".wav";

                    String[] options = {
                        "--video-title=vlcj video output"
                    };

                    playList_bell.addMedia(now_serving, options);
                    playList_bell.addMedia(counter, options);
                }

                mediaListPlayer_bell.play();

            }
        });
        t.start();

//        mediaPlayer.mute(false);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Settings ">
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

    public void set_player() {

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);
        String[] VLC_ARGS = {};
        mediaPlayerFactory = new MediaPlayerFactory();

        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(videoSurface);
        mediaPlayer.enableMarquee(true);
        mediaPlayer.setFullScreen(true);

        mediaPlayer.setVolume(0);
        MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();

        mediaListPlayer.setMediaPlayer(mediaPlayer); // <--- Important, associate the media player with the media list player

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(canvas, BorderLayout.CENTER);
        MediaList mediaList = mediaPlayerFactory.newMediaList();

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

        //Call 
        factory_bell = new MediaPlayerFactory();
        mediaListPlayer_bell = factory_bell.newMediaListPlayer();
        playList_bell = factory_bell.newMediaList();

        mediaListPlayer_bell.setMode(MediaListPlayerMode.DEFAULT);
        mediaListPlayer_bell.setMediaList(playList_bell);

        mediaListPlayer_bell.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
            @Override
            public void played(MediaListPlayer mediaListPlayer) {
                System.out.println("mediaListPlayer: " + mediaListPlayer.currentMrl());
            }

            @Override
            public void mediaSubItemAdded(MediaListPlayer mediaListPlayer, libvlc_media_t subItem) {

                System.out.println("mediaListPlayer: " + mediaListPlayer.currentMrl() + " = " + subItem.toString());
            }

            @Override
            public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {

                String[] s = playlist.get(0).split(",");
                String queue_no = s[0];
                String counter_no = s[1];
                jLabel1.setText(queue_no);
                jLabel2.setText(counter_no);

            }

            @Override
            public void mediaStateChanged(MediaListPlayer mediaListPlayer, int newState) {

                String media = mediaListPlayer.currentMrl();
                mediaPlayer.mute(true);
               


                if (media.contains("counter")) {
                    int cn_index1 = media.indexOf("counter/");
                    int cn_index2 = media.indexOf(".wav");

                    counter_no = media.substring(cn_index1 + 8, cn_index2);
                    counter_no = counter_no.replace("/", "");
                    if (!counter_no.isEmpty() && !queue_no.isEmpty()) {
                        jLabel2.setText(counter_no);
                        jLabel1.setText(queue_no);
                        playlist.remove(0);
                        queue_no = "";
                        counter_no = "";

                    } else {
                        System.out.println("media: " + media);
                        if (ii == 1) {
                            mediaPlayer.mute(false);
                            ii = 0;
                        }
                        ii++;
                    }

                }
                if (media.contains("letters")) {
                    int cn_index1 = media.indexOf("letters/");
                    int cn_index2 = media.indexOf(".wav");
                    queue_no = media.substring(cn_index1 + 8, cn_index2);
                    queue_no = queue_no.replace("/", "");

                }

//                System.out.println("mediaListPlayer: " + mediaListPlayer.currentMrl());
            }

        });

    }
    int is_playing = 0;
    int ii = 0;
    String queue_no = "";
    String counter_no = "";
    //</editor-fold>
}
