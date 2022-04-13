package com.revature;

import com.revature.db.UserDao;
import com.revature.models.User;
import com.revature.models.Role;
import com.revature.services.UserService;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Boolean loggedIn = false;

        while(!loggedIn){

            System.out.println("Welcome. Do you want to login (enter 1) or register (enter 2)?");
            int response = scan.nextInt();
            if(response == 1){

                loggedIn = true;
            }
            else if(response == 2) {
                System.out.println("What will your username be?");
                String username = scan.nextLine();
                System.out.println("What bout your password?");
                String password = scan.nextLine();
                System.out.println("What's your email?");
                String email = scan.nextLine();
                System.out.println("Are you an employee (enter 1) or the one in charge (enter 2)?");
                response = scan.nextInt();
                if(response == 1) {
                    UserService.register(username,password,email,Role.valueOf("EMPLOYEE"));
                }
                else if(response == 2){
                    UserService.register(username,password,email,Role.valueOf("FINANCE_MANAGER"));
                }
            }


        }


        }
    }
