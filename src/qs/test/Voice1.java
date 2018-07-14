/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

/**
 *
 * @author Guinness
 */
import com.sun.speech.freetts.*;
import com.sun.speech.freetts.VoiceManager;
import java.util.ArrayList;
import java.util.List;

public class Voice1 {

    public static void main(String[] args) {

        System.setProperty("mbrola.base", "C:\\Users\\Guinness\\Documents\\apps\\lib\\MBrola\\");

        VoiceManager voiceManager = VoiceManager.getInstance();
        String voice = "alan";
        Voice helloVoice = voiceManager.getVoice(voice);
        if (helloVoice == null) {
            Voice[] availableVoices = voiceManager.getVoices();
            List<String> voiceList = new ArrayList<>();
            for (Voice v : availableVoices) {
                voiceList.add(v.getName());
            }
            System.out.println("Not a valid voice: " + voice + "\nValid voices: " + voiceList);
            return;
        }

        helloVoice.allocate();
//        helloVoice.setRate(150);
//        helloVoice.setPitch(150);
        helloVoice.speak("Please proceed to counter 02");
        helloVoice.deallocate();
    }

}
