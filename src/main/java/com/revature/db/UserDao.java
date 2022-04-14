package com.revature.db;

import com.revature.db.ConnectionManager;
import com.revature.models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserDao  {

    public static User create(@NotNull User model) {
        String sql = "INSERT INTO ers_users (ers_username, ers_password, user_email) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);

            pstmt.setString(1, model.getUsername());
            pstmt.setString(2, model.getPassword());
            pstmt.setString(3, model.getEmail());
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
            String SQL = "SELECT * FROM ers_users WHERE ers_username = ?";
            Connection conn = com.revature.db.ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                model.setId(rs.getInt("ers_users_id"));
                model.setUsername(rs.getString("ers_username"));
                model.setPassword(rs.getString("ers_password"));
                model.setEmail(rs.getString("user_email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }


    public static void delete(int id) {
        String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void delete(User model) {
        String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
        try {
            PreparedStatement pstmt = com.revature.db.ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}