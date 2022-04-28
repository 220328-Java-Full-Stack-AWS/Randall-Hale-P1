package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.db.UserDao;
import com.revature.models.User;
import com.revature.services.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User model = mapper.readValue(req.getInputStream(), User.class);

        UserDao.create(model);
        resp.setStatus(201);

    }

    

}
