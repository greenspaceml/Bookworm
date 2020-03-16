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
import models.Photo;

/**
 *
 * @author hongq
 */
public class PhotoDAO extends DBContext {

    public Photo getPhotoByUserID(String id) throws Exception {
        Photo p = new Photo();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "SELECT UserPhoto.PhotoID, Photo.PhotoName, Photo.Title \n"
                    + " FROM Photo INNER JOIN\n"
                    + " UserPhoto ON Photo.ID = UserPhoto.PhotoID INNER JOIN\n"
                    + " [User] ON [User].ID = UserPhoto.UserID\n"
                    + " where [User].ID = ?";
            connection = dBContext.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                p.setID(rs.getString("PhotoID"));
                p.setPhotoname(rs.getString("PhotoName"));
                p.setTittle(rs.getString("Title"));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return p;
    }

    public boolean editUserPhotoByUserID(String photoName, String userID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  Update Photo\n"
                    + "  Set PhotoName = ?\n"
                    + "  From Photo p inner join UserPhoto up\n"
                    + "  On p.ID = up.PhotoID\n"
                    + "  WHERE up.UserID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, photoName);
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

    public boolean editUserPhotoTitleByUserID(String photoTitle, String userID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  Update Photo\n"
                    + "  Set"
                    + "	  Title = ?\n"
                    + "  From Photo p inner join UserPhoto up\n"
                    + "  On p.ID = up.PhotoID\n"
                    + "  WHERE up.UserID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, photoTitle);
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

    public boolean insertUsertoPhoto(String photoID, String photoName, String photoTitle) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " insert into Photo (ID,PhotoName,Title) values\n"
                    + " (?,?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, photoID);
            ps.setString(2, photoName);
            ps.setString(3, photoTitle);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public boolean insertUsertoUserPhoto(String userID, String photoID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " insert into UserPhoto (UserID,PhotoID) values\n"
                    + " (?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, photoID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }
}
