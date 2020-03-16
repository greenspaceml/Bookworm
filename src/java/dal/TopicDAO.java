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
import models.Topic;

/**
 *
 * @author hongq
 */
public class TopicDAO extends DBContext {

    public ArrayList<Topic> getTopicsByPostID(String postID) {
        ArrayList<Topic> topics = new ArrayList<>();
        try {
            String sql = " SELECT t.ID, t.Text\n"
                    + " FROM Poster p inner join TopicOfPoster tp\n"
                    + " ON p.ID = tp.PostID inner join Topic t\n"
                    + " ON tp.TopicID = t.ID\n"
                    + " where p.ID = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, postID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Topic t = new Topic();
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
                topics.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topics;
    }

    public boolean insertToTopicwhenUploadPost(String postID, String topicID) {
        int check = 0;
        try {
            String sql = "  insert into TopicOfPoster(PostID,TopicID) values\n"
                    + " (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            ps.setString(2, topicID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public ArrayList<Topic> getTopics() {
        ArrayList<Topic> listTopics = new ArrayList<>();
        try {
            String sql = "Select * from Topic";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Topic t = new Topic();
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
                listTopics.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTopics;
    }

    public ArrayList<String> getListTopicIDByDESC() {
        ArrayList<String> listTopicID = new ArrayList<>();
        try {
            String sql = "  select t.ID\n"
                    + "  FROM Topic t inner join TopicOfPoster tp\n"
                    + "  ON t.ID = tp.TopicID\n"
                    + "  group by t.ID\n"
                    + "  ORDER BY count(tp.PostID) desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTopicID.add(rs.getString("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTopicID;
    }

    public Topic getTopicbyTopicID(String topicID) {
        Topic t = new Topic();
        try {
            String sql = "  SELECT *\n"
                    + "  From Topic\n"
                    + "  where topic.ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t.setID(rs.getString("ID"));
                t.setText(rs.getString("Text"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public int getCountPostsbyTopicID(String topicID) {
        int count = 0;
        try {
            String sql = "  SELECT count(po.ID) as N\n"
                    + "  FROM Poster po inner join TopicOfPoster tp\n"
                    + "  ON po.ID = tp.PostID\n"
                    + "  where tp.TopicID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, topicID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    

}
