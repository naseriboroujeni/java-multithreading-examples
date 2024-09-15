package org.example6;

import java.awt.image.BufferedImage;

public class ImageProcessor {

    public static void recolorImage(
            BufferedImage originalImage,
            BufferedImage resultImage,
            int leftCorner,
            int topCorner,
            int width,
            int height
    ) {

        for(int x = leftCorner ; x < leftCorner + width && x < originalImage.getWidth() ; x++) {
            for(int y = topCorner ; y < topCorner + height && y < originalImage.getHeight() ; y++) {
                recolorPixel(originalImage, resultImage, x , y);
            }
        }
    }

    public static void recolorPixel(BufferedImage orriginalImage, BufferedImage resultImage, int x, int y) {
        int rgb = orriginalImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed = red;
        int newGreen = green;
        int newBlue = blue;

        if (isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        }

        int newRgb = createRgbFromColors(newRed, newGreen, newBlue);
        setRgb(resultImage, newRgb, x, y);
    }

    public static void setRgb(BufferedImage image, int rgb, int x, int y) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }

    public static int createRgbFromColors(int red, int green, int blue) {
        int rgb = 0;

        rgb |= red << 16;
        rgb |= green << 8;
        rgb |= blue;
        rgb |= 0xFF000000;

        return rgb;
    }

    public static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 &&
                Math.abs(red - blue) < 30 &&
                Math.abs(green - blue) < 30;
    }
}
