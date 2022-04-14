package com.revature;

import com.revature.models.User;
import com.revature.services.AuthService;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Boolean loggedIn = false;
        User currUser = null;

        while(!loggedIn){

            System.out.println("Welcome. Do you want to login (enter 1) or register (enter 2)?");
            int response = Integer.parseInt(scan.nextLine());
            if(response == 1){

                System.out.println("What is your username?");
                String username = scan.nextLine();
                System.out.println("Enter your password.");
                String password = scan.nextLine();

                currUser = AuthService.login(username,password);

                if(currUser != null) {
                    loggedIn = true;
                    System.out.println("Congrats. You've made it.");
                    continue;
                }

            }
            else if(response == 2) {
                System.out.println("Provide username");
                String username = scan.nextLine();
                System.out.println("Provide password");
                String password = scan.nextLine();
                System.out.println("What's your email?");
                String email = scan.nextLine();

                AuthService.register(username,password,email);
            }
        }
        System.out.println("Wow. you really made it out of there chap. Outstanding");
        }
    }
