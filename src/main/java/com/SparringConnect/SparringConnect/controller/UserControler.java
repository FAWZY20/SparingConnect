package com.SparringConnect.SparringConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.SparringConnect.SparringConnect.model.User;
import com.SparringConnect.SparringConnect.repositoy.UserRepository;

@Controller
public class UserControler {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUser")
    public java.util.List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/registrerForm")
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "view/index";
        }
        userRepository.save(user);
        return "view/registerSucces";
    }

    @DeleteMapping("/deleteAllUser")
    public void deletteAllUser(){
         userRepository.deleteAll();
    }
}
