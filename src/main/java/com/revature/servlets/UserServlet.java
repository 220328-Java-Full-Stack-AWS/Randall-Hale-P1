package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.db.ReimbursementDao;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class UserServlet extends HttpServlet {

    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int user_id = Integer.parseInt(req.getHeader("authToken"));

        List<Reimbursement> pulled = ReimbursementDao.getAllByUser(user_id);

        resp.setContentType("application/json");

        String json = mapper.writeValueAsString(pulled);
        resp.getWriter().print(json);
        resp.setStatus(200);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reimbursement newReimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);

        Timestamp submitted = new Timestamp(System.currentTimeMillis());

        int author = Integer.parseInt(req.getHeader("authToken"));

        newReimbursement.setSubmitted(submitted);
        newReimbursement.setAuthor(author);
        newReimbursement.setStatus(0);

        ReimbursementDao.create(newReimbursement);

        String json = mapper.writeValueAsString(newReimbursement);
        resp.getWriter().print(json);
        resp.setStatus(203);


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reimbursement editReimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
        ReimbursementDao.update(editReimbursement);
        resp.setStatus(200);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getHeader("reimb_id"));
        ReimbursementDao.delete(id);
        resp.setStatus(200);

    }

}