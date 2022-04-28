package com.revature.db;

import com.revature.db.ConnectionManager;
import com.revature.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserDao  {

    public static User create(User model) {
        String sql = "INSERT INTO ers_users (username, password, first, last, email, role) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);

            pstmt.setString(1, model.getUsername());
            pstmt.setString(2, model.getPassword());
            pstmt.setString(3, model.getFirst());
            pstmt.setString(4, model.getLast());
            pstmt.setString(5, model.getEmail());
            pstmt.setInt(6, model.getRole());
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


    public static User read(String username) {
        User model = new User();
        try {
            String SQL = "SELECT * FROM ers_users WHERE username = ?";
            Connection conn = com.revature.db.ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                model.setId(rs.getInt("id"));
                model.setUsername(rs.getString("username"));
                model.setPassword(rs.getString("password"));
                model.setFirst(rs.getString("first"));
                model.setLast(rs.getString("last"));
                model.setEmail(rs.getString("email"));
                model.setRole(rs.getInt("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    public static User read(int id) {
        User model = new User();
        try {
            String SQL = "SELECT * FROM ers_users WHERE id = ?";
            Connection conn = com.revature.db.ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                model.setId(rs.getInt("id"));
                model.setUsername(rs.getString("username"));
                model.setPassword(rs.getString("password"));
                model.setFirst(rs.getString("first"));
                model.setLast(rs.getString("last"));
                model.setEmail(rs.getString("email"));
                model.setRole(rs.getInt("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    public static void update(User model){

    }



    public static void delete(int id) {
        String sql = "DELETE FROM ers_users WHERE id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void delete(User model) {
        String sql = "DELETE FROM ers_users WHERE id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String username) {
        String sql = "DELETE FROM ers_users WHERE username = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}