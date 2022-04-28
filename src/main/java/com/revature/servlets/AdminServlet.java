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

public class AdminServlet extends HttpServlet {

    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int filter_val = Integer.parseInt(req.getParameter("status"));

        List<Reimbursement> pulled = ReimbursementDao.getAll(filter_val);

        System.out.println(pulled);
        System.out.println(pulled.size());

        resp.setContentType("application/json");

        String json = mapper.writeValueAsString(pulled);
        resp.getWriter().print(json);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reimbursement model = ReimbursementDao.read(Integer.parseInt(req.getHeader("reimb_id")));
        model.setStatus(Integer.parseInt(req.getHeader("reimb_status")));

        Timestamp resolved = new Timestamp(System.currentTimeMillis());
        model.setResolved(resolved);

        ReimbursementDao.update(model);
        resp.setStatus(200);

    }


}