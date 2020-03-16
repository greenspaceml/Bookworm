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
import models.Poster;
import models.User;
import processSupporter.ProcessSupport;

/**
 * // * // * @author hongq //
 */
public class PosterDAO extends DBContext {

    public ArrayList<Poster> getPostersByRecent() {
        ArrayList<Poster> listPosters = new ArrayList<>();
        String sql = " Select * from Poster order by PostingDate desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
                listPosters.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPosters;
    }

    public ArrayList<Poster> getIDPostersByHighlight() {
        ArrayList<Poster> listPosters = new ArrayList<>();
        String sql = " SELECT p.ID\n"
                + " FROM Poster p inner join Comment c \n"
                + " ON p.ID = c.PostID inner join [User] u\n"
                + " On c.UserID = u.ID\n"
                + " GROUP BY p.ID\n"
                + " Order by Count(c.ID) desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                listPosters.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPosters;
    }

    public Poster getPosterByID(String postID) {
        Poster p = new Poster();
        try {
            String sql = " SELECT *\n"
                    + " FROM Poster p\n"
                    + " WHERE p.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public ArrayList<Poster> getPostersbyUserID(String userID) {
        ArrayList<Poster> listPosters = new ArrayList<>();
        String sql = " SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID\n"
                + " FROM [User] u inner join Poster p \n"
                + " ON u.ID = p.UserID\n"
                + " where u.ID = ?\n"
                + " ORDER BY p.PostingDate desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    Poster p = new Poster();
                    p.setID(rs.getString("ID"));
                    p.setPostName(rs.getString("PostName"));
                    User u = new User();
                    u.setID(rs.getString("UserID"));
                    p.setUser(u);
                    p.setImage(rs.getString("image"));
                    p.setText(rs.getString("Text"));
                    p.setPostingDate(rs.getDate("PostingDate"));
                    listPosters.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPosters;
    }

    public int countPorts() {
        int count = 0;
        try {
            String sql = " Select count(p.ID) as N from Poster p ";
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public boolean UploadPost(String posterID, String PostName, String userID, String photoName, String text) {
        int check = 0;
        ProcessSupport support = new ProcessSupport();
        try {
            String sql = " insert into Poster (ID,PostName,UserID,Image,Text,PostingDate) values\n"
                    + " (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, posterID); //DONE
            ps.setString(2, PostName); // get
            ps.setString(3, userID); // get 
            ps.setString(4, photoName);  //get 
            ps.setString(5, text); //get
            ps.setString(6, support.getCurrentDate()); //DONE
            check = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public ArrayList<Poster> getPosterByTopicID(String topicID) {
        ArrayList<Poster> listposters = new ArrayList<>();

        try {
            String sql = "  SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID\n"
                    + "  FROM Poster p inner join TopicOfPoster tp\n"
                    + "  ON p.ID = tp.PostID\n"
                    + "  WHERE tp.TopicID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
                listposters.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listposters;
    }

    public Poster getPosterByCommentID(String commentID) {
        Poster p = new Poster();
        try {
            String sql = "  SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID \n"
                    + "  FROM Comment c inner join Poster p\n"
                    + "  ON c.PostID = p.ID\n"
                    + "  where c.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, commentID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public ArrayList<Poster> searchByPosterName(String containsName) {
        ArrayList<Poster> listposter = new ArrayList<>();
        try {
            String sql = "   SELECT *\n"
                    + "   FROM Poster p\n"
                    + "   WHERE p.PostName LIKE "+"'% "+containsName+"%'"; 
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1, "'%"+containsName+"%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
                listposter.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listposter;
    }

    public ArrayList<Poster> searchByPosterScript(String containsText) {
        ArrayList<Poster> listposter = new ArrayList<>();
        try {
            String sql = "      SELECT *\n"
                    + "   FROM Poster p\n"
                    + "   WHERE p.Text LIKE "+"'%"+containsText+"%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1, containsText);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                p.setPostName(rs.getString("PostName"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                p.setUser(u);
                p.setImage(rs.getString("image"));
                p.setText(rs.getString("Text"));
                p.setPostingDate(rs.getDate("PostingDate"));
                listposter.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listposter;
    }

    public boolean deletePostByPostID(String postID) {
        int check = 0;
        try {
            String sql = "   Delete from Poster \n"
                    + "   where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
             check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

}
