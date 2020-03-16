/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import until.SessionHelper;

/**
 *
 * @author hongq
 */
public class ChangePasswordController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean check = false;
        User user = SessionHelper.getUserFromSession(request.getSession());
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        UserDAO userDAO = new UserDAO();
        if (oldPassword.equals(user.getPassword())) {
            if (newPassword1.equals(newPassword2)) {
                try {
                    check = userDAO.changeUserpassword(newPassword1, user.getID());
                    if (check) {

                        out.println("                    <script src='https://cdn.jsdelivr.net/npm/sweetalert2@8'></script>");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                        out.println("<script>");
                        out.println("$(document).ready(function(){");
                        out.println("Swal.fire({");
                        out.println("  position: 'top-end',");
                        out.println(" type: 'success',");
                        out.println(" title: 'Password changed successful',");
                        out.println("showConfirmButton: false,");
                        out.println("timer: 1500");
                        out.println("})");
                        out.println("});");
                        out.println("</script>");
                        request.getRequestDispatcher("changePassword.jsp").include(request, response);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'NEW password does not match !', 'error');");
                out.println("});");
                out.println("</script>");
                request.getRequestDispatcher("changePassword.jsp").include(request, response);
            }
        } else {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal('Oops...', 'OLD password does not match !', 'error');");
            out.println("});");
            out.println("</script>");
            request.getRequestDispatcher("changePassword.jsp").include(request, response);
        }

    }

}
