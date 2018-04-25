package com.ccy.software.controller;

import com.ccy.ocr.CcyApi;
import com.ccy.ocr.ProcressData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by ÎÄ½­ on 2018/4/24.
 */
@RequestMapping("ccy")
@Controller
public class CcyController {

    @RequestMapping("discern")
    @ResponseBody
    public String discern(HttpServletRequest request, MultipartFile file) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File newFile = new File(path + "/" + fileName);
        String reslu = "";
        if (!newFile.exists()) {
            try {
                newFile.mkdirs();
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        try {
            file.transferTo(newFile);
            reslu = CcyApi.testEn(fileName, new File(ProcressData.path[ProcressData.index(fileName)]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reslu;
    }
}
