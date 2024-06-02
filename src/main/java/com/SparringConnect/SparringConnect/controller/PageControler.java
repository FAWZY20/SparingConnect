package com.SparringConnect.SparringConnect.controller;

import com.SparringConnect.SparringConnect.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControler {

    @GetMapping("/")
    public ModelAndView home(Model model) {
        model.addAttribute("user", new User());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/index");
        return mav;
    }

    @GetMapping("/registrer")
    public ModelAndView register(Model model){
        model.addAttribute("user", new User());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/registration");
        return mav;
    }

    @GetMapping("/adminHome")
    public ModelAndView adminHome(Model model){
        model.addAttribute("user", new User());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/adminHome");
        return mav;
    }

    @GetMapping("/profil")
    public ModelAndView profil(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", new User());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/profil");
        return mav;
    }

}
