/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import qs.util.ExecuteShellComand;

/**
 *
 * @author Guinness
 */
public class Shell {

    public static void main(String[] args) {
        final String espeak_version = System.getProperty("espeak_version", "en-us");
        final String espeak_gender = System.getProperty("espeak_gender", "+f3");
        final String espeak_speed = System.getProperty("espeak_speed", "160");
        final String espeak_amplitude = System.getProperty("espeak_amplitude", "250");
        final String espeak_pitch = System.getProperty("espeak_pitch", "40");
        ExecuteShellComand cmd = new ExecuteShellComand();
        String command = " espeak -v" + espeak_version + espeak_gender + " " + "-s" + espeak_speed + " -a" + espeak_amplitude + " -p" + espeak_pitch + " \"             Now Serving, Ticket number. " + "B--1. Please Proceed to Counter 2.";
        String output = cmd.executeCommand(command);
    }
}
