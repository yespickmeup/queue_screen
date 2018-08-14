/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import jaco.mp3.player.MP3Player;
import java.io.File;

/**
 *
 * @author Guinness
 */
public class Wav {

    public static void main(String[] args) {
        speak2();
    }

    public static void speak2() {
        String file_serving = "C:\\Users\\Guinness\\rsc_queue\\synthesize\\now_serving.wav";
        File file1 = new File(file_serving);
        File file2 = new File(file_serving);
        File file3 = new File(file_serving);

        new MP3Player(file1, file2, file3).play();
    }

}
