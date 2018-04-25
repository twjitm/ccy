package com.ccy.ocr;

import com.recognition.software.jdeskew.ImageDeskew;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CcyApi {



    /**
     * @param args
     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        OCR ocr = new OCR();

        try {

            // String maybe = new OCR().recognizeText(new File("f:test.png"), "png");
            //System.out.println(maybe);
            testEn("Two_Tigers",new File(ProcressData.path[1]));
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    //ʹ��Ӣ���ֿ� - ʶ��ͼƬ
    public static String testEn(String fileName, File file) throws Exception {
        BufferedImage image = ImageIO.read(file);
        //��ͼƬ���д���
        image = convertImage(image);
        ITesseract instance = new Tesseract();//JNA Interface Mapping
       // instance.setDatapath("E:\\tessdata\\tessdata");

        instance.setDatapath("G:\\git\\ccy\\tessdata");
        /**
         *
         */
        // instance.setLanguage("eng");//��������ֿ�
        List<String> config = new ArrayList<String>();
        // config.add("����");
        // config.add("")
        //config.add("����");
        instance.setConfigs(config);
        instance.setOcrEngineMode(0);
        //����ͼƬ
        String result = instance.doOCR(image); //ʶ��
        System.out.println("ʶ����ɡ�������������������������");
        System.out.println(result);
        System.out.println("��ʼƥ��ѵ������������������������");
        int index = ProcressData.index(fileName);
        switch (index) {
            case 0:
                result = ProcressData.processorhutudeai(result);
                break;
            case 1:
                result = ProcressData.processorTwo_Tigers(result);
                break;
            case 2:
                result = ProcressData.processorjiandanai(result);
                break;
            case 3:
                result = ProcressData.processorhutudeai(result);
                break;
        }
        return result;
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


}