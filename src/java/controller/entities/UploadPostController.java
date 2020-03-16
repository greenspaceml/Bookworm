/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.PosterDAO;
import dal.TopicOfPosterDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import processSupporter.ProcessSupport;
import until.SessionHelper;

/**
 *
 * @author hongq
 */
public class UploadPostController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean checkPoster = false;
        boolean checkTopic = false;
        ProcessSupport support = new ProcessSupport();
        String newPosterID = "po" + support.getCurrentDateForCommentID();
        PosterDAO posterDAO = new PosterDAO();
        TopicOfPosterDAO topicOfPosterDAO = new TopicOfPosterDAO();
        User user = SessionHelper.getUserFromSession(request.getSession());
        String posterName = request.getParameter("posterName").trim();
        String posterText = request.getParameter("posterText").trim();
        String filephoto = request.getParameter("myFile");
        String[] listTopicID = request.getParameterValues("tid");
        if (!posterName.isEmpty() && !posterText.isEmpty() && !filephoto.isEmpty() && listTopicID.length != 0) {
            checkPoster = posterDAO.UploadPost(newPosterID, posterName, user.getID(), filephoto, posterText);
            for (int i = 0; i < listTopicID.length; i++) {
                String temp = listTopicID[i];
                checkTopic = topicOfPosterDAO.UploadToTopicofPoster(newPosterID, temp);
            }
        }

        if (checkPoster && checkTopic) {
            response.sendRedirect("list");
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Update</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + "Post falsed !" + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
