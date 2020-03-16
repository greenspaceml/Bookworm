/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.CommentDAO;
import dal.PosterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Poster;

/**
 *
 * @author hongq
 */
public class DeleteCommentController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentDAO commentDAO = new CommentDAO();        
        String commentID = request.getParameter("cid");
        PosterDAO posterDAO = new PosterDAO();
        Poster poster = posterDAO.getPosterByCommentID(commentID);
        boolean check = commentDAO.deleteCommentByCommentID(commentID);
        if (check) {
            response.sendRedirect("singlePost?poid=" + poster.getID());
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
