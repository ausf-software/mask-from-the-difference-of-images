/*
 * Copyright © 2023 Shcherbina Daniil
 * License: http://opensource.org/licenses/MIT
 */

package io.github.ausf_software;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MaskGenerator {

    private static BufferedImage original;
    private static BufferedImage wMask;
    private static BufferedImage result;

    public static void loadFiles(String orig, String withMask) throws IOException {
        original = ImageIO.read(new File(orig));
        wMask = ImageIO.read(new File(withMask));
    }

    public static boolean checkSize() {
        if (original == null || wMask == null) return false;
        return original.getWidth() == wMask.getWidth() && original.getHeight() == wMask.getHeight();
    }

    public static void calculate() {
        result = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {
                Color o = new Color(original.getRGB(i, j));
                Color w = new Color(wMask.getRGB(i, j));
                Color r = newCol(o, w);
                result.setRGB(i, j,  r.getRGB());
            }
        }
    }

    private static Color newCol(Color orig, Color with) {
        int r = 0, g = 0, b = 0;
        int oR = orig.getRed() / 2;
        int oG = orig.getGreen() / 2;
        int oB = orig.getBlue() / 2;

        r = (with.getRed() - oR) * 2;
        b = (with.getBlue() - oB) * 2;
        g = (with.getGreen() - oG) * 2;
        if (r >= 0 && g >= 0 && b >= 0) {
            if (r > 254) r = 254;
            if (g > 254) g = 254;
            if (b > 254) b = 254;
            return new Color(r, g, b, 127);
        }
        return with;
    }

    public static BufferedImage getResult() {
        return result;
    }
}
