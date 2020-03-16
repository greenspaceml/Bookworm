/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.CommentDAO;
import dal.PosterDAO;
import dal.ReportDAO;
import dal.TopicOfPosterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hongq
 */
public class DeletePostController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            boolean checkComment = false;
            boolean checkTOP = false;
            boolean checkPoster = false;
            boolean checkReport = false;
            CommentDAO commentDAO = new CommentDAO();
            PosterDAO posterDAO = new PosterDAO();
            TopicOfPosterDAO topicOfPosterDAO = new TopicOfPosterDAO();
            ReportDAO reportDAO = new ReportDAO();
            String posterID = request.getParameter("poid");
            if (commentDAO.getCommentCountByPostID(posterID) != 0) {
                checkComment = commentDAO.deleteCommentByPostID(posterID);
            }else{
                checkComment = true;
            }
            if (reportDAO.getReportCountByPostID(posterID) != 0) {
                checkReport = reportDAO.deleteReportByPostID(posterID);
            }else{
                checkReport = true;
            }
            checkTOP = topicOfPosterDAO.deleteTopicOfPosterByPosterID(posterID);
            checkPoster = posterDAO.deletePostByPostID(posterID);
            if (checkComment && checkTOP && checkPoster && checkReport) {
                response.sendRedirect("list");
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + "Delete falsed !" + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DeletePostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
