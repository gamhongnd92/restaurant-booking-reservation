package com.csis3275.group4.controller;

import com.csis3275.group4.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SessionController {

    @PostMapping("/checkuser")
    public String checkUser(@RequestParam("page") String page, HttpServletRequest request){
        String user = request.getSession().getAttribute("USER_NAME").toString();
        if(user != null || user != ""){
            return  "redirect:/" + page;
        }
        else{
            return "redirect:/login";
        }
    }
}
