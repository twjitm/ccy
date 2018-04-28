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

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　    ┃　　　　　　　┃
 * 　   ┃　　　━　　　┃
 * 　    ┃　┳┛　┗┳    ┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */

public class CcyApi {


    /**
     * @param args
     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        OCR ocr = new OCR();

        try {

           // String maybe = ocr.recognizeText(new File("F:\\lzlh.png"), "png");
            //System.out.println(maybe);
             String result = testEn("Two_Tigers", new File(ProcressData.path[1]));
            System.out.println(result);
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    /**
     * 客户端调用接口
     *
     * @param fileName
     * @return
     */
    public static String webtestEn(String fileName) {
        int index = ProcressData.index(fileName);
        String resule = "";
        switch (index) {
            case 0:
                resule = ProcressData.hutudeaiStr;
                break;
            case 1:
                resule = ProcressData.tow_tilgersStr;
                break;
            case 2:
                resule = ProcressData.JDaStr;
                break;
            case 3:
                resule = ProcressData.kuailequshiStr;
                break;
        }
        return resule;
    }

    //使用英文字库 - 识别图片
    public static String testEn(String fileName, File file) throws Exception {
        BufferedImage image = ImageIO.read(file);
        //对图片进行处理
        image = convertImage(image);
        ITesseract instance = new Tesseract();//JNA Interface Mapping
        // instance.setDatapath("E:\\tessdata\\tessdata");

        instance.setDatapath("G:\\git\\ccy\\tessdata");
        /**
         *
         */
        // instance.setLanguage("eng");//添加中文字库
        List<String> config = new ArrayList<String>();
        // config.add("数字");
        // config.add("")
        //config.add("音符");
        instance.setConfigs(config);
        instance.setOcrEngineMode(0);
        //矫正图片
        String result = instance.doOCR(image); //识别
        System.out.println("识别完成。。。。。。。。。。。。。");
        System.out.println(result);
        System.out.println("开始匹配训练。。。。。。。。。。。");
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
                result = ProcressData.pricessorkuaileqishi(result);
                break;
        }
        System.out.println("训练完成");
        return result;
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


}