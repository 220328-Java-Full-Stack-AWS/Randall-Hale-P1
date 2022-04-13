package com.revature.services;

import com.revature.db.UserDao;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {

    private static int newId = 1;

    public void login(String username, String password) {
        System.out.println("Not ready yet.");
    }

    public static void register(String username, String password, String email, Role role){

        User newUser = new User(newId, username, password, role, email);

        UserDao.create(newUser);

        newId++;
        System.out.println("you just registered");

    }

}
