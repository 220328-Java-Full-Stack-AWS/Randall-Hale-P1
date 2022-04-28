package com.revature;

import com.revature.db.ReimbursementDao;
import com.revature.db.UserDao;
import com.revature.models.Reimbursement;
import com.revature.services.AuthService;
import com.revature.models.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Driver {

    public static void main(String[] args){

        // Reimbursement test = new Reimbursement();
        // test.setDescription("yaya");
        // test.setAmount(10);

        // ReimbursementDao.create(test);

        // Timestamp ts = new Timestamp(System.currentTimeMillis());

        // Reimbursement newd = new Reimbursement(0,0,12d,1,2, 1,"yep", ts, ts);
        // for(int i = 0; i < 4; i++){
        //    ReimbursementDao.create(newd);
        // }

        List<Reimbursement> fuck = ReimbursementDao.getAll(0);
        System.out.println(fuck.size());


    }



}
