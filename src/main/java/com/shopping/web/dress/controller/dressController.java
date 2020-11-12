package com.shopping.web.dress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/dress")
public class dressController {

    @RequestMapping(value="/dressList", method = RequestMethod.GET)
    public String getHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/dress/dressList";
    }

    @RequestMapping(value = "/good/a", method = RequestMethod.GET)
    public String getApage(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        return "/dress/good/a";
    }

    @RequestMapping(value = "/good/b", method = RequestMethod.GET)
    public String getBpage(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        return "/dress/good/b";
    }

    @RequestMapping(value = "/good/c", method = RequestMethod.GET)
    public String getCpage(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        return "/dress/good/c";
    }

    @RequestMapping(value = "/good/d", method = RequestMethod.GET)
    public String getDpage(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        return "/dress/good/d";
    }

   }