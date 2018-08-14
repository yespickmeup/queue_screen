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
public class NewClass {
    public static void main(String[] args) {
        String stmt="01";
        if(stmt.length()==2){
            String s1=stmt.substring(0,1);
            if(s1.equalsIgnoreCase("0")){
                stmt=stmt.substring(1, 2);
            }
        }
        System.out.println(stmt);
    }
}
