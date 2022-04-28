package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.db.UserDao;
import com.revature.models.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;

public class RegisterServlet extends HttpServlet {

    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User model = mapper.readValue(req.getInputStream(), User.class);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10,new SecureRandom());
        String encodedPw = encoder.encode(model.getPassword());

        model.setPassword(encodedPw);

        UserDao.create(model);
        resp.setStatus(201);

    }

    

}
