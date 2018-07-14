/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Guinness
 */
public class RoundedFieldUI extends BasicTextFieldUI {

    private final int round = 5;
    private final int shadeWidth = 2;
    private final int textSpacing = 3;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        c.setOpaque(false);

        int s = shadeWidth + 1 + textSpacing;
        c.setBorder(BorderFactory.createEmptyBorder(s, s, s, s));
    }

    @Override
    protected void paintSafely(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        Shape border = getBorderShape();

        Stroke os = g2d.getStroke();
        g2d.setStroke(new BasicStroke(shadeWidth * 2));
        g2d.setPaint(Color.WHITE);
        g2d.draw(border);
        g2d.setStroke(os);

        g2d.setPaint(Color.WHITE);
        g2d.fill(border);

        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.draw(border);

        super.paintSafely(g);
    }

    private Shape getBorderShape() {
        JTextComponent component = getComponent();
        if (round > 0) {
            return new RoundRectangle2D.Double(shadeWidth, shadeWidth,
                                               component.getWidth() - shadeWidth * 2 - 1,
                                               component.getHeight() - shadeWidth * 2 - 1, round * 2, round * 2);
        } else {
            return new Rectangle2D.Double(shadeWidth, shadeWidth,
                                          component.getWidth() - shadeWidth * 2 - 1,
                                          component.getHeight() - shadeWidth * 2 - 1);
        }
    }
}
