package com.SparringConnect.SparringConnect.service;

import com.SparringConnect.SparringConnect.model.User;
import com.SparringConnect.SparringConnect.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String userAuthentification(String mail, String pwd){
        if (userRepository.findUserByMailAndPassword(mail, pwd) != null){
            return "view/adminHome";
        }else{
            return "view/index";
        }
    }
}
