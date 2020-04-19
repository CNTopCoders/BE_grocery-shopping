package com.alias.uploadcet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-20 01:37
 */
@Controller
public class FrontRedirect {
    @RequestMapping("/ms")
    public void jumpMs(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }
}
