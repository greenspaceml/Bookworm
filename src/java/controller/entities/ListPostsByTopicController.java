/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.TopicDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Topic;

/**
 *
 * @author hongq
 */
public class ListPostsByTopicController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TopicDAO topicDAO = new TopicDAO();
            String tid = request.getParameter("tid");
            Topic topic = topicDAO.getTopicbyTopicID(tid);
            request.setAttribute("topic", topic);
            request.getRequestDispatcher("listPostsByTopic.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListPostsByTopicController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
