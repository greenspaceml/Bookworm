/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.DBContext;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import until.SessionHelper;

/**
 *
 * @author sonnt
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {
    User u;

    private boolean isAuthenticated(HttpServletRequest request) {
        User user = SessionHelper.getUserFromSession(request.getSession());
        if (user != null) {
            return true;
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                return false;
            } else {
                String username = null;
                String password = null;
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        username = cooky.getValue();
                    }
                    if (cooky.getName().equals("password")) {
                        password = cooky.getValue();
                    }
                    if (username != null && password != null) {
                        break;
                    }
                }
                if (username != null && password != null) {
                    UserDAO userDAO = new UserDAO();
                    u = new User();
                    u = userDAO.getUserByUsernameAndPassword(username, password);
                    user = userDAO.getUserByUsernameAndPassword(username, password);
                    if (user != null) {
                        SessionHelper.addUserToSession(request.getSession(), user);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processGet(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

}
