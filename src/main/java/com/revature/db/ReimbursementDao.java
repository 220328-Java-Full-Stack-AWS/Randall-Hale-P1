package com.revature.db;

import com.revature.models.Reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReimbursementDao {


    public static Reimbursement create(Reimbursement model) {

        String sql = "INSERT INTO ers_reimbursement (status, amount, author, resolver, type, description, submitted, resolved) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);

            pstmt.setInt(1, model.getStatus());
            pstmt.setDouble(2, model.getAmount());
            pstmt.setInt(3, model.getAuthor());
            pstmt.setInt(4, model.getResolver());
            pstmt.setInt(5, model.getType());
            pstmt.setString(6, model.getDescription());
            pstmt.setTimestamp(7, model.getSubmitted());
            pstmt.setTimestamp(8, model.getResolved());
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
            String SQL = "SELECT * FROM ers_reimbursement WHERE id = ?";
            Connection conn = com.revature.db.ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {

                // status, amount, author, resolver, type, description,  submitted, resolved
                model.setId(rs.getInt("id"));
                model.setStatus(rs.getInt("status"));
                model.setAmount(rs.getDouble("amount"));
                model.setAuthor(rs.getInt("author"));
                model.setResolver(rs.getInt("resolver"));
                model.setDescription(rs.getString("description"));
                model.setSubmitted(rs.getTimestamp("submitted"));
                model.setResolved(rs.getTimestamp("resolved"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    // status, amount, author, resolver, type, description, receipt, submitted, resolved

    public static void update(Reimbursement model) {

        String sql = "UPDATE ers_reimbursement SET status = ?, amount = ?, author = ?, resolver = ?, type = ?, description = ?, submitted = ?, resolved = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);

            pstmt.setInt(1, model.getStatus());
            pstmt.setDouble(2, model.getAmount());
            pstmt.setInt(3, model.getAuthor());
            pstmt.setInt(4, model.getResolver());
            pstmt.setInt(5, model.getType());
            pstmt.setString(6, model.getDescription());
            pstmt.setTimestamp(7, model.getSubmitted());
            pstmt.setTimestamp(8, model.getResolved());
            pstmt.setInt(9, model.getId());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delete(int id) {
        String sql = "DELETE FROM ers_reimbursement WHERE id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void delete(Reimbursement model) {
        String sql = "DELETE FROM ers_reimbursement WHERE id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<Reimbursement> getAllByUser(int author){

        List<Reimbursement> list = new LinkedList<>();
        String sql = "SELECT * from ers_reimbursement WHERE author = ?";

        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, author);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Reimbursement model = new Reimbursement();

                model.setId(rs.getInt("id"));
                model.setStatus(rs.getInt("status"));
                model.setAmount(rs.getDouble("amount"));
                model.setAuthor(rs.getInt("author"));
                model.setResolver(rs.getInt("resolver"));
                model.setDescription(rs.getString("description"));
                model.setSubmitted(rs.getTimestamp("submitted"));
                model.setResolved(rs.getTimestamp("resolved"));

                list.add(model);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;


    }


    public static List<Reimbursement> getAll(int filter_value) {

        List<Reimbursement> list = new LinkedList<>();
        String sql = "SELECT * from ers_reimbursement WHERE status = ?";

        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, filter_value);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Reimbursement model = new Reimbursement();

                model.setId(rs.getInt("id"));
                model.setStatus(rs.getInt("status"));
                model.setAmount(rs.getDouble("amount"));
                model.setAuthor(rs.getInt("author"));
                model.setResolver(rs.getInt("resolver"));
                model.setDescription(rs.getString("description"));
                model.setSubmitted(rs.getTimestamp("submitted"));
                model.setResolved(rs.getTimestamp("resolved"));

                list.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
