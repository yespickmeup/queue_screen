/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;
import queue.Dlg_queue2;

/**
 *
 * @author Guinness
 */
public class CThread {

    public static void main(String[] args) {

        ThreadGroup lThreadGroup = new ThreadGroup("CThread's Group");

        for (int count = 0; count < 10; count++) {
            CThread1 lCThread = new CThread1(lThreadGroup, "Thread - " + count);
            lCThread.start();
        }

//        while (lThreadGroup.activeCount() > 0) {
//            try {
//                System.out.println("Waiting for " + lThreadGroup.activeCount() + " CThreads to Complete");
//               
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    static class CThread1 extends Thread {

        public CThread1(ThreadGroup pThreadGroup, String pThreadName) {
            super(pThreadGroup, pThreadName);
        }

        public void run() {
            try {
                String directory = System.getProperty("user.home");
                directory = directory + "\\rsc_queue\\bell.wav";
                String queue_no = "A1";
                System.out.println(this.getName() + " Thread begins..");
                String bell = System.getProperty("user.home");
                bell = bell + "\\rsc_queue\\bell.wav";
                String directory2 = System.getProperty("user.home");
                directory2 = directory2 + "\\rsc_queue\\voices\\";
                String q1 = queue_no.substring(0, 1);
                String q2 = queue_no.substring(1, queue_no.length());
                String now_serving = directory2 + q1 + "\\" + q2 + ".wav";
                String counter = directory2 + "counter\\" + "1" + ".wav";
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
                System.out.println(this.getName() + " Thread ends...");
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
