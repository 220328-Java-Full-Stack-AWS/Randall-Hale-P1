package com.revature.services;

import com.revature.db.UserDao;
import com.revature.models.User;

import java.util.Objects;

public class AuthService {

    private static int newId = 1;

    public static User login(String username, String password) {

        User loginUser = UserDao.read(username);

        if(Objects.equals(loginUser.getPassword(), password)) {
            return loginUser;
        }

        System.out.println("Incorrect password. Please login again");
        return null;

    }

    public static void register(String username, String password, String first, String last, String email){

        User newUser = new User(0, 0, username, password, first, last, email);

        UserDao.create(newUser);

        System.out.println("you just registered");

    }

}
