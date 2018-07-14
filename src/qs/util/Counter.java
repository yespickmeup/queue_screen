/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Counter {

    public static int getAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (dateOfBirth != null) {
            now.setTime(new Date());
            born.setTime(dateOfBirth);
            if (born.after(now)) {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
                age -= 1;
            }
        }
        return age;
    }

    public static int getDayCount(Date from, Date to) {

        int f_year = FitIn.toInt(DateType.y.format(from));
        int f_month = FitIn.toInt(DateType.m1.format(from));
        int f_yday = FitIn.toInt(DateType.d.format(from));

        int t_year = FitIn.toInt(DateType.y.format(to));
        int t_month = FitIn.toInt(DateType.m1.format(to));
        int t_day = FitIn.toInt(DateType.d.format(to));

        GregorianCalendar start = new GregorianCalendar(f_year, f_month, f_yday);
        GregorianCalendar end = new GregorianCalendar(t_year, t_month, t_day);
        int days = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 365
                + (end.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR));

        return days;
    }

    public static void main(String[] args) {
        try {
            Date from = DateType.sf.parse("2015-02-09");
            Date to = DateType.sf.parse("2015-02-10");
            int days = getDayCount(from, to);
            System.out.println(days);
        } catch (ParseException ex) {
            Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
