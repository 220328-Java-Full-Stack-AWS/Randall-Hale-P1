package com.revature.db;

import com.revature.models.Reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDao {


    public static Reimbursement create(Reimbursement model) {

        String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_author, reimb_description, reimb_status_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);

            pstmt.setDouble(1, model.getAmount());
            pstmt.setInt(2, model.getAuthor());
            pstmt.setString(3, model.getDescription());
            pstmt.setInt(4, model.getStatus());
            pstmt.executeUpdate();


            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                int key = keys.getInt(1);
                model.setId(key);
            }

            return model;

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }


    public static Reimbursement read(int id) {
        Reimbursement model = new Reimbursement();
        try {
            String SQL = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
            Connection conn = com.revature.db.ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                model.setDescription(rs.getString("reimb_description"));
                model.setAmount(rs.getDouble("reimb_amount"));
                model.setAuthor(rs.getInt("reimb_author"));
                model.setStatus(rs.getInt("reimb_status_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    public static void update(Reimbursement model) {

        String sql = "UPDATE ers_reimbursement SET reimb_description = ?, reimb_amount = ?, reimb_author = ?, reimb_status_id = ? WHERE reimb_id = ?";

        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, model.getDescription());
            pstmt.setDouble(2, model.getAmount());
            pstmt.setInt(3, model.getAuthor());
            pstmt.setInt(4, model.getStatus());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delete(int id) {
        String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void delete(Reimbursement model) {
        String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
