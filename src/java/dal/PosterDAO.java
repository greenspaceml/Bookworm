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
import models.Poster;
import models.User;
import processSupporter.ProcessSupport;

/**
 * // * // * @author hongq //
 */
public class PosterDAO extends DBContext {

    public ArrayList<Poster> getPostersByRecent() throws Exception {
        ArrayList<Poster> listPosters = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        String sql = " Select * from Poster order by PostingDate desc";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listPosters;
    }

    public ArrayList<Poster> getIDPostersByHighlight() throws Exception {
        ArrayList<Poster> listPosters = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        String sql = " SELECT p.ID\n"
                + " FROM Poster p inner join Comment c \n"
                + " ON p.ID = c.PostID inner join [User] u\n"
                + " On c.UserID = u.ID\n"
                + " GROUP BY p.ID\n"
                + " Order by Count(c.ID) desc";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Poster p = new Poster();
                p.setID(rs.getString("ID"));
                listPosters.add(p);

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listPosters;
    }

    public Poster getPosterByID(String postID) throws Exception {
        Poster p = new Poster();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " SELECT *\n"
                    + " FROM Poster p\n"
                    + " WHERE p.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return p;
    }

    public ArrayList<Poster> getPostersbyUserID(String userID) throws Exception {
        ArrayList<Poster> listPosters = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        String sql = " SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID\n"
                + " FROM [User] u inner join Poster p \n"
                + " ON u.ID = p.UserID\n"
                + " where u.ID = ?\n"
                + " ORDER BY p.PostingDate desc";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listPosters;
    }

    public int countPorts() throws Exception {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " Select count(p.ID) as N from Poster p ";
            connection = dBContext.getConnection();
            ps = connection.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return count;
    }

    public boolean UploadPost(String posterID, String PostName, String userID, String photoName, String text) throws Exception {
        int check = 0;
        ProcessSupport support = new ProcessSupport();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " insert into Poster (ID,PostName,UserID,Image,Text,PostingDate) values\n"
                    + " (?,?,?,?,?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, posterID); //DONE
            ps.setString(2, PostName); // get
            ps.setString(3, userID); // get 
            ps.setString(4, photoName);  //get 
            ps.setString(5, text); //get
            ps.setString(6, support.getCurrentDate()); //DONE
            check = ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public ArrayList<Poster> getPosterByTopicID(String topicID) throws Exception {
        ArrayList<Poster> listposters = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID\n"
                    + "  FROM Poster p inner join TopicOfPoster tp\n"
                    + "  ON p.ID = tp.PostID\n"
                    + "  WHERE tp.TopicID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listposters;
    }

    public Poster getPosterByCommentID(String commentID) throws Exception {
        Poster p = new Poster();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  SELECT p.ID, p.Image, p.PostingDate, p.PostName, p.Text, p.UserID \n"
                    + "  FROM Comment c inner join Poster p\n"
                    + "  ON c.PostID = p.ID\n"
                    + "  where c.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, commentID);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return p;
    }

    public ArrayList<Poster> searchByPosterName(String containsName) throws Exception {
        ArrayList<Poster> listposter = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "   SELECT *\n"
                    + "   FROM Poster p\n"
                    + "   WHERE p.PostName LIKE " + "'% " + "?" + "%'";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, containsName);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listposter;
    }

    public ArrayList<Poster> searchByPosterScript(String containsText) throws Exception {
        ArrayList<Poster> listposter = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "      SELECT *\n"
                    + "   FROM Poster p\n"
                    + "   WHERE p.Text LIKE " + "'%" + "?" + "%'";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, containsText);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listposter;
    }

    public boolean deletePostByPostID(String postID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "   Delete from Poster \n"
                    + "   where ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
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
