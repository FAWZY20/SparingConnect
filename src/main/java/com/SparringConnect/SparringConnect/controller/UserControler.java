package com.SparringConnect.SparringConnect.controller;

import com.SparringConnect.SparringConnect.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import com.SparringConnect.SparringConnect.model.User;
import com.SparringConnect.SparringConnect.repositoy.UserRepository;

@Controller
public class UserControler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/registrerForm")
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "view/index";
        }
        userRepository.save(user);
        return "view/registerSucces";
    }

    @PostMapping("/connexion")
    public String connexion(@ModelAttribute("user") User user,Model model,  HttpSession session){
        return userService.userAuthentification(user.getMail(), user.getPassword(), model, session);
    }

    @GetMapping("/updateUser")
    public String test(){
        return "view/profil";
    }

    @PutExchange("/updateUser")
    public String updateUser(@ModelAttribute("user") User updatedUser, HttpSession session){
        userService.updateUser(updatedUser, session);
        return "view/profil";
    }
}
