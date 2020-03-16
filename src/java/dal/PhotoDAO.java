/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Photo;

/**
 *
 * @author hongq
 */
public class PhotoDAO extends DBContext {

    public Photo getPhotoByUserID(String id) {
        Photo p = new Photo();
        try {
            String sql = "SELECT UserPhoto.PhotoID, Photo.PhotoName, Photo.Title \n"
                    + " FROM Photo INNER JOIN\n"
                    + " UserPhoto ON Photo.ID = UserPhoto.PhotoID INNER JOIN\n"
                    + " [User] ON [User].ID = UserPhoto.UserID\n"
                    + " where [User].ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                p.setID(rs.getString("PhotoID"));
                p.setPhotoname(rs.getString("PhotoName"));
                p.setTittle(rs.getString("Title"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PhotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public boolean editUserPhotoByUserID(String photoName, String userID) {
        int check = 0;
        try {
            String sql = "  Update Photo\n"
                    + "  Set PhotoName = ?\n"
                    + "  From Photo p inner join UserPhoto up\n"
                    + "  On p.ID = up.PhotoID\n"
                    + "  WHERE up.UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, photoName);
            ps.setString(2, userID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean editUserPhotoTitleByUserID(String photoTitle, String userID) {
        int check = 0;
        try {
            String sql = "  Update Photo\n"
                    + "  Set"
                    + "	  Title = ?\n"
                    + "  From Photo p inner join UserPhoto up\n"
                    + "  On p.ID = up.PhotoID\n"
                    + "  WHERE up.UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, photoTitle);
            ps.setString(2, userID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean insertUsertoPhoto(String photoID,String photoName, String photoTitle) {
        int check = 0;
        try {
            String sql = " insert into Photo (ID,PhotoName,Title) values\n"
                    + " (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, photoID);
            ps.setString(2, photoName);
            ps.setString(3, photoTitle);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
        public boolean insertUsertoUserPhoto(String userID, String photoID) {
        int check = 0;
        try {
            String sql = " insert into UserPhoto (UserID,PhotoID) values\n"
                    + " (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, photoID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
