/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Comment;
import models.Poster;
import models.User;
import processSupporter.ProcessSupport;

/**
 *
 * @author hongq
 */
public class CommentDAO extends DBContext {

    public ArrayList<Comment> getCommentsByPostID(String PostID) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String sql = " SELECT c.ID,c.UserID,c.PostID,c.Text,c.CommentDate\n"
                    + " FROM Poster p inner join Comment c \n"
                    + " ON p.ID = c.PostID inner join [User] u\n"
                    + " On c.UserID = u.ID\n"
                    + " WHERE p.ID = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, PostID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setID(rs.getString("ID"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                c.setUser(u);
                Poster p = new Poster();
                p.setID(rs.getString("PostID"));
                c.setPoster(p);
                c.setText(rs.getString("Text"));
                c.setCommentDate(rs.getDate("CommentDate"));
                comments.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public int getCommentCountByPostID(String PostID) {
        int count = 0;
        try {
            String sql = " SELECT Count(c.ID)  as N \n"
                    + " FROM Poster p inner join Comment c \n"
                    + " ON p.ID = c.PostID inner join [User] u\n"
                    + " On c.UserID = u.ID\n"
                    + " WHERE p.ID = ?\n"
                    + " GROUP BY p.ID";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, PostID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    /*    public int countComments() {
        int count = 0;
        try {
            String sql = " Select count(c.ID) as N from Comment c ";
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
     */
    public boolean uploadComment(String userID, String postID, String text) {
        int check = 0;
        ProcessSupport support = new ProcessSupport();
        try {
            String sql = "  Insert into Comment (ID,CommentDate,UserID,PostID,Text) values\n"
                    + " (?,?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ("c" + support.getCurrentDateForCommentID()));
            ps.setString(2, support.getCurrentDate());
            ps.setString(3, userID);
            ps.setString(4, postID);
            ps.setString(5, text);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean deleteCommentByCommentID(String commentID) {
        int check = 0;
        try {
            String sql = "  Delete From Comment\n"
                    + "  where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, commentID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean deleteCommentByPostID(String PostID) {
        int check = 0;
        try {
            String sql = "   delete from Comment\n"
                    + "   where PostID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, PostID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
