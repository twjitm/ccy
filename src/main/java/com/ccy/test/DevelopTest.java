package com.ccy.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by 文江 on 2018/4/28.
 */
public class DevelopTest {
    public static synchronized String recognizeText(File imageFile, String imageFormat) throws Exception {
        String tessPath = "C:\\Program Files (x86)\\Tesseract-OCR\\";
        File outputFile = new File(imageFile.getParentFile(), "output");
        StringBuffer strB = new StringBuffer();
        String[] cm = new String[]{tessPath + "tesseract", imageFile.getAbsolutePath(), outputFile.getAbsolutePath(), "-l", "normal"};
        System.out.println("执行的命令是    ");
        for (String str : cm) {
            System.out.print(str + " ");
        }
        Process pb = Runtime.getRuntime().exec(cm);
        int w = pb.waitFor();
        if (w == 0) {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile
                    .getAbsolutePath()
                    + ".txt"), "UTF-8"));
            System.out.println("正在读取" + outputFile
                    .getAbsolutePath()
                    + ".txt 文件");
            String str;
            while ((str = in.readLine()) != null) {
                strB.append(str);
            }
            System.out.println("读取完成 结果是 " + strB.toString());
            in.close();
        } else {
            String msg;
            switch (w) {
                case 1:
                    msg = "Errors accessing files. There may be spaces in your image's filename.";
                    break;
                case 29:
                    msg = "Cannot recognize the image or its selected region.";
                    break;
                case 31:
                    msg = "Unsupported image format.";
                    break;
                default:
                    msg = "Errors occurred.";
            }
//             tempImage.delete();
            throw new RuntimeException(msg);
        }
//         new File(outputFile.getAbsolutePath() + ".txt").delete();
        return strB.toString();
    }

    public static void main(String[] args) {
       /* try {
            System.out.println(recognizeText(new File("F:\\lzlh.png"), "png"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put(1, "134");
        hashMap.put("1", "1341222");
        System.out.println(hashMap.get("1"));

    }
}
