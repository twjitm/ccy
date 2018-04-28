/*
 * OCR.java
 *
 * Created on December 24, 2007, 12:38 AM
 */

package com.ccy.ocr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OCR {
	protected transient final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String LANG_OPTION = "-l";
	private final String EOL = System.getProperty("line.separator");
	private String tessPath = new File("C:\\Program Files (x86)\\Tesseract-OCR").getAbsolutePath();

	/*public String recognizeText(File imageFile, String imageFormat) throws Exception {
		File tempImage = ImageIOHelper.createImage(imageFile, imageFormat);

		File outputFile = new File(imageFile.getParentFile(), "output");
		StringBuffer strB = new StringBuffer();

		List<String> cmd = new ArrayList<String>();
		cmd.add("//tesseract");
		cmd.add(outputFile.getName());
		cmd.add(LANG_OPTION);
		cmd.add("eng");

		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(imageFile.getParentFile());

		cmd.set(1, tempImage.getName());
		System.out.println("执行的命令为:"+cmd);
		pb.command(cmd);
		pb.redirectErrorStream(true);
		Process process = pb.start();

		int w = process.waitFor();
		logger.debug("Exit value = {}", w);

		// delete temp working files
		tempImage.delete();

		if (w == 0) {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile
					.getAbsolutePath()
					+ ".txt"), "UTF-8"));

			String str;

			while ((str = in.readLine()) != null) {
				strB.append(str).append(EOL);
			}
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
			tempImage.delete();
			throw new RuntimeException(msg);
		}

		new File(outputFile.getAbsolutePath() + ".txt").delete();
		logger.info("图像识别结果:{}", strB);
		return strB.toString();
	}*/

	public String recognizeText(File imageFile,String imageFormat)throws Exception{
		File tempImage = ImageIOHelper.createImage(imageFile,imageFormat);
		File outputFile = new File(imageFile.getParentFile(),"output");
		StringBuffer strB = new StringBuffer();
		List<String> cmd = new ArrayList<String>();
		cmd.add(tessPath+"//tesseract");
		/*if(OS.isWindowsXP()){
			cmd.add(tessPath+"//tesseract");
		}else if(OS.isLinux()){
			cmd.add("tesseract");
		}else{
			cmd.add(tessPath+"//tesseract");
		}*/
		cmd.add("");
		cmd.add(outputFile.getName());
		cmd.add(LANG_OPTION);
		cmd.add("eng");
		//cmd.add("eng");

		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(imageFile.getParentFile());

		cmd.set(1, tempImage.getName());
		pb.command(cmd);
		pb.redirectErrorStream(true);

		Process process = pb.start();
		//tesseract.exe 1.jpg 1 -l chi_sim
		int w = process.waitFor();

		//删除临时正在工作文件
		tempImage.delete();

		if(w==0){
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile.getAbsolutePath()+".txt"),"UTF-8"));

			String str;
			while((str = in.readLine())!=null){
				strB.append(str).append(EOL);
			}
			in.close();
		}else{
			String msg;
			switch(w){
				case 1:
					msg = "Errors accessing files.There may be spaces in your image's filename.";
					break;
				case 29:
					msg = "Cannot recongnize the image or its selected region.";
					break;
				case 31:
					msg = "Unsupported image format.";
					break;
				default:
					msg = "Errors occurred.";
			}
			tempImage.delete();
			throw new RuntimeException(msg);
		}
		new File(outputFile.getAbsolutePath()+".txt").delete();
		return strB.toString();
	}

}
