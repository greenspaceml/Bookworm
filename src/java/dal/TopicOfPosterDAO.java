/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hongq
 */
public class TopicOfPosterDAO extends DBContext {

    public boolean UploadToTopicofPoster(String postID, String topicID) {
        int check = 0;
        try {
            String sql = " insert into TopicOfPoster(PostID,TopicID) values\n"
                    + " (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            ps.setString(2, topicID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TopicOfPosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean deleteTopicOfPosterByPosterID(String postID) {
        int check = 0;
        try {
            String sql = "   delete from TopicOfPoster\n"
                    + "   where PostID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, postID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TopicOfPosterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
