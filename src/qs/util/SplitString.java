/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class SplitString {
    public static List<String> split(String exp){
         List<String> datas=new ArrayList();
         String[] aw=exp.split(",", exp.length());
         for(String s:aw){
//             System.out.println(s);
             datas.add(s);
         }
         if(exp.isEmpty()){
             datas=new ArrayList();
         }
         return datas;
    }
    public static String revert(List<String> datas){  
        int i=0;
        String output="";
        for(String s:datas){
            if(i==0){
               output=s; 
            }else{
               output=output+","+s; 
            }
            i++;
        }
        return output;
    }
    
}
