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

    //使用英文字库 - 识别图片
    public static void testEn() throws Exception {
        String[] path = new String[]{"c:jiaqunshougua.png", "f:yangben/Two_Tigers.jpg", "f:yangben/mlh.png",
                "f:dt.gif"};
        File imageFile = new File(path[1]);
        BufferedImage image = ImageIO.read(imageFile);
        //对图片进行处理
        image = convertImage(image);
        ITesseract instance = new Tesseract();//JNA Interface Mapping
        instance.setDatapath("E:\\tessdata\\tessdata");
        /**
         *
         */
        //instance.setLanguage("eng");//添加中文字库
        //矫正图片
        String result = instance.doOCR(image); //识别
        System.out.println("识别完成。。。。。。。。。。。。。");
        System.out.println(result);
        System.out.println("开始匹配训练。。。。。。。。。。。");
        processorTwo_Tigers(result);

    }

    //对图片进行处理 - 提高识别度
    public static BufferedImage convertImage(BufferedImage image) throws Exception {
        //按指定宽高创建一个图像副本
        //image = ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight());
        //图像转换成灰度的简单方法 - 黑白处理
        ImageDeskew id = new ImageDeskew(image);
        double imageSkewAngle = id.getSkewAngle(); //获取倾斜角度
        if ((imageSkewAngle > 0.05d || imageSkewAngle < -(0.05d))) {
            image = ImageHelper.rotateImage(image, -imageSkewAngle); //纠偏图像
        }
        image = ImageHelper.convertImageToGrayscale(image);
        //图像缩放 - 放大n倍图像
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