/*
 * Copyright © 2023 Shcherbina Daniil
 * License: http://opensource.org/licenses/MIT
 */


package io.github.ausf_software;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HomeWindow {
    private JPanel rootPanel;
    private JTextField originalImageField;
    private JTextField imageWithMaskField;
    private JTextField maskOutputField;
    private JButton submitButton;
    private JButton imageWithMaskButton;
    private JButton maskOutputButton;
    private JLabel origImageText;
    private JLabel imageWithMaskText;
    private JLabel maskText;
    private JButton originalImageButton;

    public HomeWindow() {
        originalImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originalImageField.setText(fileChose("Original image"));
            }
        });

        imageWithMaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageWithMaskField.setText(fileChose("Image with mask"));
            }
        });

        maskOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maskOutputField.setText(dirChose("Mask output"));
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFiles();
            }
        });
    }

    private String dirChose(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(rootPanel);

        if (result == JFileChooser.APPROVE_OPTION )
            return fileChooser.getSelectedFile().toString();
        return null;
    }

    private String fileChose(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Images", "png", "jpeg", "jpg");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(rootPanel);

        if (result == JFileChooser.APPROVE_OPTION )
            return fileChooser.getSelectedFile().toString();
        return null;
    }

    private void checkFiles() {
        if (origImageText.getText() == null || origImageText.getText().trim().equals("") ||
            imageWithMaskField.getText() == null || imageWithMaskField.getText().trim().equals("") ||
            maskOutputField.getText() == null || maskOutputField.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(rootPanel, "Field is empty!");
        } else {
            try {
                MaskGenerator.loadFiles(originalImageField.getText(), imageWithMaskField.getText());
                if (!MaskGenerator.checkSize()) {
                    JOptionPane.showMessageDialog(rootPanel, "Incorrect size!");
                } else {
                    MaskGenerator.calculate();
                    File outputfile = new File(maskOutputField.getText() + "\\Mask.png");
                    ImageIO.write(MaskGenerator.getResult(), "png", outputfile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
