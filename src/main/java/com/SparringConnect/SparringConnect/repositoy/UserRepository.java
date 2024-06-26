package com.SparringConnect.SparringConnect.repositoy;

import com.SparringConnect.SparringConnect.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByMailAndPassword(String email,String pwd);

    User findUserByMail(String mail);
}
