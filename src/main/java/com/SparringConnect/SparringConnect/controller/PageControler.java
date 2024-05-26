package com.SparringConnect.SparringConnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControler {

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/index");
        return mav;
    }

    @GetMapping("/registrer")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/registration");
        return mav;
    }

}
