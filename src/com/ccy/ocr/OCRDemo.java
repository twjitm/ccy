package com.ccy.ocr;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCRDemo {

	public static void main(String[] args) throws TesseractException {
		ITesseract instance = new Tesseract();
		//���δ��tessdata���ڸ�Ŀ¼����Ҫָ������·��
		//instance.setDatapath("the absolute path of tessdata");
		// ������Ҫָ��ʶ������
		instance.setLanguage("chi_sim");
		// ָ��ʶ��ͼƬ
		File imgDir = new File("test_chinese_07.PNG");
		long startTime = System.currentTimeMillis();
		String ocrResult = instance.doOCR(imgDir);
		// ���ʶ����
		System.out.println("OCR Result: \n" + ocrResult + "\n ��ʱ��" + (System.currentTimeMillis() - startTime) + "ms");
	}
}