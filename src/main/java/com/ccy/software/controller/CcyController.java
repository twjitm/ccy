package com.ccy.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by ÎÄ½­ on 2018/4/24.
 */
@RequestMapping("ccy")
@Controller
public class CcyController {

    @RequestMapping("discern")
    @ResponseBody
    public String discern(HttpServletRequest request, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File file1 =new File("");
        return "";
    }
}
