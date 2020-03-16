/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.PhotoDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import processSupporter.ProcessSupport;

/**
 *
 * @author hongq
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            ProcessSupport support = new ProcessSupport();
            boolean Ucheck = false;
            boolean Pcheck = false;
            boolean PUcheck = false;
            String userID = ("u" + support.getCurrentDateForCommentID());
            String photoID = ("p" + support.getCurrentDateForCommentID());
            String displayName = request.getParameter("name");
            String hobbies = request.getParameter("hobbies");
            String DOB = (String) request.getParameter("DOB");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAO();
            PhotoDAO photoDAO = new PhotoDAO();
            Ucheck = userDAO.createNewAccount(userID, displayName, DOB, hobbies, username, password);
            Pcheck = photoDAO.insertUsertoPhoto(photoID, "defaultImg.png", " ");
            PUcheck = photoDAO.insertUsertoUserPhoto(userID, photoID);
            if (Ucheck && Pcheck && PUcheck) {
                response.sendRedirect("login");
            }
        } catch (Exception ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
