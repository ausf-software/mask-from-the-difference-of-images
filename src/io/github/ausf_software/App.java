/*
 * Copyright © 2023 Shcherbina Daniil
 * License: http://opensource.org/licenses/MIT
 */

package io.github.ausf_software;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class App {

    static{
        UIManager.put("Panel.background", new Color(60,63,65));
        UIManager.put("ScrollPanel.background", new Color(60,63,65));

        UIManager.put("ComboBox.background", new Color(76, 80,82));
        UIManager.put ("ComboBox.font", new Font(" ", Font.PLAIN, 16));
        UIManager.put("ComboBox.foreground", new Color(187,187,187));
        UIManager.put("ComboBox.border",
                new CompoundBorder(new LineBorder(new Color(99, 99, 99), 2, true),
                        new EmptyBorder(0, 3, 0, 0)));

        UIManager.put("List.background", new Color(60,63,65));
        UIManager.put ("List.font", new Font(" ", Font.PLAIN, 14));
        UIManager.put("List.foreground", new Color(187,187,187));

        UIManager.put("TextField.background", new Color(76, 80,82));

        UIManager.put("TextField.background", new Color(76, 80,82));
        UIManager.put ("TextField.font", new Font(" ", Font.PLAIN, 18));
        UIManager.put("TextField.foreground", new Color(187,187,187));
        UIManager.put("TextField.border",
                new CompoundBorder(new LineBorder(new Color(99, 99, 99), 2, true),
                                    new EmptyBorder(0, 3, 0, 0)));
        //UIManager.put("TextField.caret-color", new Color(187,187,187));

        UIManager.put("Label.foreground", new Color(187,187,187));
        UIManager.put ("Label.font", new Font(" ", Font.PLAIN, 18));

        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("Button.foreground", new Color(187,187,187));
        UIManager.put ("Button.font", new Font(" ", Font.PLAIN, 18));
        UIManager.put("Button.background", new Color(76, 80,82));
        UIManager.put("Button.select", new Color(86, 90,92));
        UIManager.put("Button.border",
                new CompoundBorder(new LineBorder(new Color(99, 99, 99), 2, true),
                                    new EmptyBorder(0, 3, 0, 0)));
    }

    public static void main(String[] args) {
        JFrame homeWindow = new JFrame("Mask from the difference of images");
        homeWindow.setSize(350, 400);
        homeWindow.setContentPane(new HomeWindow().getRootPanel());
        homeWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeWindow.setVisible(true);
        homeWindow.setLocationRelativeTo(null);
        homeWindow.setResizable(false);
    }

}
