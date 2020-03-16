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
import java.util.ArrayList;
import models.Topic;

/**
 *
 * @author hongq
 */
public class TopicDAO extends DBContext {

    public ArrayList<Topic> getTopicsByPostID(String postID) throws Exception {
        ArrayList<Topic> topics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " SELECT t.ID, t.Text\n"
                    + " FROM Poster p inner join TopicOfPoster tp\n"
                    + " ON p.ID = tp.PostID inner join Topic t\n"
                    + " ON tp.TopicID = t.ID\n"
                    + " where p.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareCall(sql);
            ps.setString(1, postID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Topic t = new Topic();
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
                topics.add(t);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return topics;
    }

    public boolean insertToTopicwhenUploadPost(String postID, String topicID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  insert into TopicOfPoster(PostID,TopicID) values\n"
                    + " (?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            ps.setString(2, topicID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public ArrayList<Topic> getTopics() throws Exception {
        ArrayList<Topic> listTopics = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "Select * from Topic";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Topic t = new Topic();
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
                listTopics.add(t);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listTopics;
    }

    public ArrayList<String> getListTopicIDByDESC() throws Exception {
        ArrayList<String> listTopicID = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  select t.ID\n"
                    + "  FROM Topic t inner join TopicOfPoster tp\n"
                    + "  ON t.ID = tp.TopicID\n"
                    + "  group by t.ID\n"
                    + "  ORDER BY count(tp.PostID) desc";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listTopicID.add(rs.getString("ID"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listTopicID;
    }

    public Topic getTopicbyTopicID(String topicID) throws Exception {
        Topic t = new Topic();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  SELECT *\n"
                    + "  From Topic\n"
                    + "  where topic.ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return t;
    }

    public int getCountPostsbyTopicID(String topicID) throws Exception {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  SELECT count(po.ID) as N\n"
                    + "  FROM Poster po inner join TopicOfPoster tp\n"
                    + "  ON po.ID = tp.PostID\n"
                    + "  where tp.TopicID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
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

}
