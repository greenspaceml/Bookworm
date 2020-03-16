/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import processSupporter.ProcessSupport;

/**
 *
 * @author hongq
 */
public class UserDAO extends DBContext {

    public ArrayList<User> Users() {
        ArrayList<User> listUsers = new ArrayList<>();
        String sql = "SELECT ID\n"
                + "      ,AccountType\n"
                + "      ,Username\n"
                + "      ,\"Password\"\n"
                + "      ,DisplayName\n"
                + "      ,DateOfbirth\n"
                + "      ,Hobbies\n"
                + "  FROM \"User\"";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User d = new User();
                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
                listUsers.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsers;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        for (User u : Users()) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public User getUserByPostID(String postID) {

        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM Poster p inner join [User] u\n"
                    + " ON p.UserID = u.ID\n"
                    + " where p.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public User getUserByCommentID(String commentID) {

        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM Comment c inner join [User] u\n"
                    + " ON c.UserID = u.ID\n"
                    + " where c.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, commentID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public User getUserByUserID(String userID) {

        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM [User] u\n"
                    + " where u.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean editProfileByuserID(String userID, String displayName, String dateOfBirth, String hobbies) {
        int check = 0;
        try {
            String sql = "  Update [User]\n"
                    + "  Set DisplayName = ?,\n"
                    + "	DateOfbirth = ?,\n"
                    + "	Hobbies = ?\n"
                    + "  WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, displayName);
            ps.setString(2, dateOfBirth);
            ps.setString(3, hobbies);
            ps.setString(4, userID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean createNewAccount(String userID, String displayName, String DOB, String hobbies, String username, String password) {
        int check = 0;
        try {
            String sql = "  insert into [User] (ID, AccountType, Username,\n"
                    + "			[Password], DisplayName,\n"
                    + "			DateOfbirth, Hobbies) values\n"
                    + " (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, "0");
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, displayName);
            ps.setString(6, DOB);
            ps.setString(7, hobbies);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean changeUserpassword(String password, String userID) {
        int check = 0;
        try {
            String sql = " update [User]\n"
                    + " set [Password] = ?\n"
                    + " where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, userID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

//    public ArrayList<User> searchByUserDisplayName(String userDisplayName) {
//        ArrayList<User> listUsers = new ArrayList<>();
//        try {
//            String sql = "      SELECT *\n"
//                    + "   FROM [User] u\n"
//                    + "   WHERE u.DisplayName LIKE %?%";
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User d = new User();
//                d.setID(rs.getString("ID"));
//                d.setUsername(rs.getString("Username"));
//                d.setPassword(rs.getString("Password"));
//                d.setDisplayname(rs.getString("DisplayName"));
//                d.setDateOfBirth(rs.getDate("DateOfbirth"));
//                d.setHobbies(rs.getString("Hobbies"));
//                d.setAccountType(rs.getBoolean("AccountType"));
//                listUsers.add(d);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listUsers;
//    }
}
