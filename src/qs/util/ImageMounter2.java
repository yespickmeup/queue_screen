/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import com.mortennobel.imagescaling.ResampleOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dummy
 */
public class ImageMounter2 {

    public static void do_set(JLabel lbl, String url) {
        try {
            int w = lbl.getWidth();
            int h = lbl.getHeight();
//            System.out.println( );
            File d = new File(url);


            BufferedImage image = javax.imageio.ImageIO.read(d);
            ResampleOp resampleOp = new ResampleOp(w, h);
            BufferedImage rescaledTomato = resampleOp.filter(image, null);
            ImageIcon starIcon = new ImageIcon(rescaledTomato);
            lbl.setIcon(starIcon); // NOI18N
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void do_set(JLabel lbl, InputStream is) {
        try {
            int w = lbl.getWidth();
            int h = lbl.getHeight();
            BufferedImage image = javax.imageio.ImageIO.read(is);
            ResampleOp resampleOp = new ResampleOp(w, h);
            BufferedImage rescaledTomato = resampleOp.filter(image, null);
            ImageIcon starIcon = new ImageIcon(rescaledTomato);
            lbl.setIcon(starIcon); // NOI18N
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
