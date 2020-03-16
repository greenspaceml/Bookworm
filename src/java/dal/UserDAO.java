/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
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

    public ArrayList<User> Users() throws Exception {
        ArrayList<User> listUsers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        String sql = "SELECT ID\n"
                + "      ,AccountType\n"
                + "      ,Username\n"
                + "      ,\"Password\"\n"
                + "      ,DisplayName\n"
                + "      ,DateOfbirth\n"
                + "      ,Hobbies\n"
                + "  FROM \"User\"";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listUsers;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws Exception {
        for (User u : Users()) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public User getUserByPostID(String postID) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM Poster p inner join [User] u\n"
                    + " ON p.UserID = u.ID\n"
                    + " where p.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return d;
    }

    public User getUserByCommentID(String commentID) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM Comment c inner join [User] u\n"
                    + " ON c.UserID = u.ID\n"
                    + " where c.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, commentID);
            rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return d;
    }

    public User getUserByUserID(String userID) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        User d = new User();
        try {
            String sql = "  Select u.ID,u.Username,u.Password,u.DisplayName,u.DateOfbirth,u.Hobbies,u.AccountType\n"
                    + " FROM [User] u\n"
                    + " where u.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {

                d.setID(rs.getString("ID"));
                d.setUsername(rs.getString("Username"));
                d.setPassword(rs.getString("Password"));
                d.setDisplayname(rs.getString("DisplayName"));
                d.setDateOfBirth(rs.getDate("DateOfbirth"));
                d.setHobbies(rs.getString("Hobbies"));
                d.setAccountType(rs.getBoolean("AccountType"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return d;
    }

    public boolean editProfileByuserID(String userID, String displayName, String dateOfBirth, String hobbies) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  Update [User]\n"
                    + "  Set DisplayName = ?,\n"
                    + "	DateOfbirth = ?,\n"
                    + "	Hobbies = ?\n"
                    + "  WHERE ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, displayName);
            ps.setString(2, dateOfBirth);
            ps.setString(3, hobbies);
            ps.setString(4, userID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public boolean createNewAccount(String userID, String displayName, String DOB, String hobbies, String username, String password) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  insert into [User] (ID, AccountType, Username,\n"
                    + "			[Password], DisplayName,\n"
                    + "			DateOfbirth, Hobbies) values\n"
                    + " (?,?,?,?,?,?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, "0");
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, displayName);
            ps.setString(6, DOB);
            ps.setString(7, hobbies);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public boolean changeUserpassword(String password, String userID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " update [User]\n"
                    + " set [Password] = ?\n"
                    + " where ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, userID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
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
