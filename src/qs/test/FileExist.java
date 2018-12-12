/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import java.io.File;

/**
 *
 * @author Ronescape
 */
public class FileExist {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "t"};
         for (String l : letters) {
             for (int i = 1; i < 501; i++) {
                 String now_serving = "C:\\Users\\Public\\Share\\Queue\\letters\\" + l + "\\" + i + ".mp3";
                 File f=new File(now_serving);
                 if(!f.exists()){
                     System.out.println("now_serving: "+now_serving);
                 }
             }
             
         }
    }
}
