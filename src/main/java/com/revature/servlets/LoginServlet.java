package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.db.UserDao;
import com.revature.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loginUser = mapper.readValue(req.getInputStream(), User.class);
        User checkUser = UserDao.read(loginUser.getUsername());

        if(checkUser != null && checkUser.getPassword().equals(loginUser.getPassword())) {
            resp.setStatus(200);
            resp.getWriter().print(new ObjectMapper().writeValueAsString(checkUser));
            resp.setHeader("access-control-expose-headers", "authToken");
            resp.setHeader("authToken", checkUser.getUsername());
        } else {resp.setStatus(401);}

    }

}