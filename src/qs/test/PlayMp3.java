/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
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
        System.setProperty("mbrola.base", "mbrola");

        String VLC_PLUGIN_PATH = System.getProperty("VLC_PLUGIN_PATH", "C:\\Program Files\\VideoLAN\\VLC\\plugins");
        String VLC_PLUGIN_NATIVE_PATH = System.getProperty("VLC_PLUGIN_NATIVE_PATH", "C:\\Program Files\\VideoLAN\\VLC");

        System.out.println("VLC_PLUGIN_PATH: " + VLC_PLUGIN_PATH);
        System.out.println("VLC_PLUGIN_NATIVE_PATH: " + VLC_PLUGIN_NATIVE_PATH);
        System.setProperty("VLC_PLUGIN_PATH", VLC_PLUGIN_PATH);

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), VLC_PLUGIN_NATIVE_PATH);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }

    private void set_player() {
        factory_bell = new MediaPlayerFactory();
        mediaListPlayer_bell = factory_bell.newMediaListPlayer();
        playList_bell = factory_bell.newMediaList();
        String[] options = {};
        String directory = System.getProperty("user.home");
        directory = directory + "\\rsc_queue\\bell.wav";
//        playList_bell.addMedia(directory, options);
        String s1 = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\now_serving.mp3";
        String num = "1";
        String letter = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\a.mp3";
        String please = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\please.wav";
        String number = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\" + num + ".mp3";
        String proceed = "C:\\Users\\Guinness\\Desktop\\Linq\\converted\\c" + num + ".wav";

        playList_bell.addMedia(letter, options);
        playList_bell.addMedia(number, options);
        playList_bell.addMedia(please, options);
        playList_bell.addMedia(proceed, options);

        mediaListPlayer_bell.setMode(MediaListPlayerMode.DEFAULT);
        mediaListPlayer_bell.setMediaList(playList_bell);

    }

    private void play() {

        mediaListPlayer_bell.play();

    }
}
