package com.action;

import java.util.*;


import com.alibaba.fastjson.JSON;
import com.coder.calculator.Util.VerifyCodeUtil;
import com.service.*;
import com.entity.*;
import com.coder.calculator.Util.CalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import  com.coder.calculator.Util.CaptchaUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IDeptService ds;
    @Autowired
    private IEmpService es;
    @Value("${spring.datasource.url}")

    private String url;

    @RequestMapping(value = "/index")
    public String index() {
        System.out.print("-------index--------url" + url);
        List<Dept> list = ds.selectAll();
        System.out.print("list=" + list);
        return "index";
    }

    @RequestMapping(value = "/textAction")
    public String textAction(HttpServletRequest request) {
        System.out.println("---------------TestAction");
        //System.out.println(" realPath : "+getServletContext().getRealPath("/"));

        String content = request.getParameter("editorValue");
        System.out.println(" editorValue: \n " + content);

        request.setAttribute("content", content);
        return "success";
    }


    @RequestMapping(path = {"sendCaptcha"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void sendCaptcha(@RequestParam("tel") String tel, HttpSession session){
        System.out.println("tel ="+tel);
       String ss=CaptchaUtil.sendCaptcha(tel);
       System.out.println("ss ="+ss);
       session.setAttribute("node",ss);
       String js= JSON.toJSONString(ss);

    }

    @RequestMapping(value = "/noteCon")
    public String noteCon(String verifyCode,HttpSession session) {
       String ss=(String)session.getAttribute("node");
        if(verifyCode.equals(ss)){
            return "success";
        }else{
            return "note";
        }

    }
}
