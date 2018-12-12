/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.util.List;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Guinness
 */
public class PlayMp3 {

    MediaPlayerFactory factory_bell = null;
    MediaListPlayer mediaListPlayer_bell = null;
    MediaList playList_bell = null;

    public static void main(String[] args) {
        PlayMp3 m = new PlayMp3();
        m.set_lib();
        m.set_player();
        m.play();
    }

    public void set_lib() {

        String VLC_PLUGIN_PATH = System.getProperty("VLC_PLUGIN_PATH", "C:\\Program Files\\VideoLAN\\VLC\\plugins");
        String VLC_PLUGIN_NATIVE_PATH = System.getProperty("VLC_PLUGIN_NATIVE_PATH", "C:\\Program Files\\VideoLAN\\VLC");

        System.out.println("VLC_PLUGIN_PATH: " + VLC_PLUGIN_PATH);
        System.out.println("VLC_PLUGIN_NATIVE_PATH: " + VLC_PLUGIN_NATIVE_PATH);
        System.setProperty("VLC_PLUGIN_PATH", VLC_PLUGIN_PATH);

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), VLC_PLUGIN_NATIVE_PATH);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }

    private void set_player() {
        try {
            factory_bell = new MediaPlayerFactory();
            mediaListPlayer_bell = factory_bell.newMediaListPlayer();
            playList_bell = factory_bell.newMediaList();
            String[] options = {
                "--video-title=vlcj video output"
            };
            mediaListPlayer_bell.setMode(MediaListPlayerMode.DEFAULT);
            mediaListPlayer_bell.setMediaList(playList_bell);

            String directory = System.getProperty("user.home");
            directory = directory + "\\rsc_queue\\bell.wav";
//        playList_bell.addMedia(directory, options);
//        String[] letters = {"a", "b", "c", "d", "e", "t"};
            String[] letters = {"t"};
//         String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (String l : letters) {
                        for (int i = 1; i < 501; i++) {

                            String now_serving = "C:\\Users\\Public\\Share\\Queue\\letters\\" + l + "\\" + i + ".mp3";
                            System.out.println("now_serving: " + now_serving);
                            String counter = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\counter\\" + i + ".mp3";
                            playList_bell.addMedia(now_serving, options);

//                playList_bell.addMedia(counter, options);
                        }
                        mediaListPlayer_bell.play();
                    }

                }
            });
            t.start();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void play() {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
