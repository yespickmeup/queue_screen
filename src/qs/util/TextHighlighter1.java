/*
 * TextHighlighter1.java
 *
 * Created on November 24, 2006, 8:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package qs.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class TextHighlighter1 {

    private TextHighlighter1() {
    }

    public static String highlight(String sentence, String word, String color) {

        Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sentence);

//        String preStr = "<span style='background-color: " + "BLACK" + "'>";
        String preStr = "<font color=" + color + ">";

        String postStr = "</font>";

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, preStr + m.group() + postStr);
        }
        m.appendTail(sb);

        return "<html> &#x0020;&#x0020;" + sb.toString() + "</html>";
    }

    public static String highlight3(String sentence, String word, String color) {

        Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sentence);

        String preStr = "<span style='background-color: " + "#6CBB3C" + "' font-color='" + "#EBF4FA" + "'>";
//        String preStr = "<font color=" + color + ">";

        String postStr = "</font>";

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, preStr + m.group() + postStr);
        }
        m.appendTail(sb);

        return "<html> &#x0020;&#x0020;" + sb.toString() + "</html>";
    }

    public static String highlight2(String sentence, String word, String color) {

        Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sentence);

        String preStr = "<span style='background-color: " + "#FF4000" + "'>";
//        String preStr = "<font color="+color+">";

        String postStr = "</font>";

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, preStr + m.group() + postStr);
        }
        m.appendTail(sb);

        return "<html> &#x0020;&#x0020;" + sb.toString() + "</html>";
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the laQUICKzy dog quick.";
        String word = "quick";
        System.out.println(highlight(sentence, word, "red"));
    }
}
