package com.ccy.software.controller;

import com.ccy.ocr.CcyApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by �Ľ� on 2018/4/24.
 */
@RequestMapping("/ccy")
@Controller
public class CcyController {

    @RequestMapping("discern")
    public String discern(HttpServletRequest request, MultipartFile file) {


        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        File newFile = new File("E:\\" + "���"+dateFormat.format(new Date())+".txt");
        String result = "";
        if (!newFile.exists()) {
            try {
              //  newFile.mkdirs();
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        result = CcyApi.webtestEn(fileName);
        request.setAttribute("result",result);
        request.setAttribute("fileName",fileName);
        try {
            // newFile.createNewFile(); // �������ļ�
            BufferedWriter out = new BufferedWriter(new FileWriter(newFile));
            out.write(result); // \r\n��Ϊ����
            out.flush(); // �ѻ���������ѹ���ļ�
            out.close(); // ���ǵùر��ļ�
            // file.transferTo(newFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "result";
    }
}
