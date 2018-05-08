package com.ccy.ocr;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Huidu {
    public static void main(String[] args) throws IOException {
        grayImage();
    }


    public  static  void grayImage() throws IOException {
        File file = new File("F:\\yangben"+"\\Two_Tiger.jpg");
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for(int i= 0 ; i < width ; i++){
            for(int j = 0 ; j < height; j++){
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }

        File newFile = new File("F:\\yangben"+"/method1.jpg");
        ImageIO.write(grayImage, "jpg", newFile);
    }
}
