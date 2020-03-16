/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import dal.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import until.SessionHelper;
import until.CookieHelper;

/**
 *
 * @author hongq
 */
public class AuthenticationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");
            UserDAO userDAO = new UserDAO();

            User user = null;

            user = userDAO.getUserByUsernameAndPassword(username, password);

            if (user != null) {
                SessionHelper.addUserToSession(request.getSession(), user);
                if (remember != null) {
                    CookieHelper.sendCookie(response, "username", user.getUsername());
                    CookieHelper.sendCookie(response, "password", user.getPassword());
                }
                if (user.isAccountType()) {
                    response.sendRedirect("admin");
                } else {
                    response.sendRedirect("list");
                }

            } else {
                response.sendRedirect("login");
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
