/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Guinness
 */
public class Placeholder {

    public static void set(JTextField tf, String value) {
        PromptSupport.setPrompt(value, tf);
    }
}
