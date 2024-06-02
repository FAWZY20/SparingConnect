package com.SparringConnect.SparringConnect.service;

import com.SparringConnect.SparringConnect.model.User;
import com.SparringConnect.SparringConnect.repositoy.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String userAuthentification(String mail, String pwd, Model model, HttpSession session){
        User user = userRepository.findUserByMailAndPassword(mail, pwd);
        if (user != null){
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "view/adminHome";
        } else {
            return "view/index";
        }
    }

    public User updateUser(User userUpdate, HttpSession session){
        User user = (User) session.getAttribute("user");
        User utilisateur = userRepository.findUserByMail(user.getMail());

        utilisateur.setPrenom(userUpdate.getPrenom());
        utilisateur.setNom(userUpdate.getNom());
        utilisateur.setMail(userUpdate.getMail());
        utilisateur.setPassword(userUpdate.getPassword());
        utilisateur.setVille(userUpdate.getVille());
        utilisateur.setAge(userUpdate.getAge());
        utilisateur.setDescription(userUpdate.getDescription());
        System.out.println(userUpdate.getVille());
        return userRepository.save(userUpdate);
    }
}
