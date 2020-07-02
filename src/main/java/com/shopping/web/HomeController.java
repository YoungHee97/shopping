package com.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePageAsRoot(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/home";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String getHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/home";
    }

}
