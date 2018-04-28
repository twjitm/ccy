package com.ccy.software.controller;

import com.ccy.ocr.CcyApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by ÎÄ½­ on 2018/4/24.
 */
@RequestMapping("/ccy")
@Controller
public class CcyController {

    @RequestMapping("discern")
    public String discern(HttpServletRequest request, MultipartFile file) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File newFile = new File(path + "/" + fileName);
        String result = "";
        /*if (!newFile.exists()) {
            try {
                newFile.mkdirs();
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }*/
        try {
            // file.transferTo(newFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        result = CcyApi.webtestEn(fileName);
        request.setAttribute("result",result);
        request.setAttribute("fileName",fileName);
        return "result";
    }
}
