package com.ccy.ocr;

import com.recognition.software.jdeskew.ImageDeskew;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Test {


    /**
     * @param args
     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        OCR ocr = new OCR();

        try {

           // String maybe = new OCR().recognizeText(new File("f:test.png"), "png");
            //System.out.println(maybe);
            testEn();
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    //ʹ��Ӣ���ֿ� - ʶ��ͼƬ
    public static void testEn() throws Exception {
        String[] path = new String[]{"c:jiaqunshougua.png", "f:yangben/Two_Tigers.jpg", "f:yangben/mlh.png",
                "f:dt.gif"};
        File imageFile = new File(path[1]);
        BufferedImage image = ImageIO.read(imageFile);
        //��ͼƬ���д���
        image = convertImage(image);
        ITesseract instance = new Tesseract();//JNA Interface Mapping
        instance.setDatapath("E:\\tessdata\\tessdata");
        /**
         *
         */
        //instance.setLanguage("eng");//��������ֿ�
        //����ͼƬ
        String result = instance.doOCR(image); //ʶ��
        System.out.println("ʶ����ɡ�������������������������");
        System.out.println(result);
        System.out.println("��ʼƥ��ѵ������������������������");
        processorTwo_Tigers(result);

    }

    //��ͼƬ���д��� - ���ʶ���
    public static BufferedImage convertImage(BufferedImage image) throws Exception {
        //��ָ����ߴ���һ��ͼ�񸱱�
        //image = ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight());
        //ͼ��ת���ɻҶȵļ򵥷��� - �ڰ״���
        ImageDeskew id = new ImageDeskew(image);
        double imageSkewAngle = id.getSkewAngle(); //��ȡ��б�Ƕ�
        if ((imageSkewAngle > 0.05d || imageSkewAngle < -(0.05d))) {
            image = ImageHelper.rotateImage(image, -imageSkewAngle); //��ƫͼ��
        }
        image = ImageHelper.convertImageToGrayscale(image);
        //ͼ������ - �Ŵ�n��ͼ��
        image = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5);
        return image;
    }


    public static String processorTwo_Tigers(String towtigersStr) {

        String[] strarr = towtigersStr.split("\n");
        System.out.println(strarr[2]);
        System.out.println(strarr[4]);
        String[] one = strarr[2].split("\\|");
        return null;

    }
}