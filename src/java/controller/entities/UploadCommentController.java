/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import until.SessionHelper;

/**
 *
 * @author hongq
 */
public class UploadCommentController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CommentDAO commentDAO = new CommentDAO();
        boolean check = false;
        User user = SessionHelper.getUserFromSession(request.getSession());
        String text = request.getParameter("textComment").trim();
        String postID = request.getParameter("postID");
        if (!text.isEmpty()) {
            check = commentDAO.uploadComment(user.getID(), postID, text);
        } else {
            check = false;
        }
        if (check) {
            response.sendRedirect("singlePost?poid=" + postID);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
