package com.cartisan.spittr.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created by Administrator on 2016/10/9.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = GET)
    public String index(){
        return "home";
    }
}
