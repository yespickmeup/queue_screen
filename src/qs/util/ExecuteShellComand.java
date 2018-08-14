/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Guinness
 */
public class ExecuteShellComand {

    public static void main(String[] args) {

        ExecuteShellComand obj = new ExecuteShellComand();
    
        String domainName = "google.com";
    
        //in mac oxs
        String command = " espeak -ven-us+f3  -a150  \"Customer number E2, please proceed to counter 01!\" ";
        //in windows
        //String command = "ping -n 3 " + domainName;
        String output = obj.executeCommand(command);
        String output2 = obj.executeCommand(command);
        System.out.println(output);
    }

     public static void main2(String[] args) {
        System.setProperty("mbrola.base", "C:\\Users\\Guinness\\Documents\\NetBeansProjects\\Speech\\mbrola");
        VoiceManager vm = VoiceManager.getInstance();
        Voice v = vm.getVoice("mbrola_us1");
        v.setDurationStretch(1);//set slow/fast talking
        v.setPitchRange(30); //30-normal
        v.allocate();
        v.speak("Customer Number 01.... please proceed to counter  2");
//        for (Voice v1 : vm.getVoices()) {
//            System.out.println("Voice: " + v1.getName());
//        }
    }
    public String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
