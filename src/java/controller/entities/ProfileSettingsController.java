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

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import until.SessionHelper;

/**
 *
 * @author hongq
 */
public class ProfileSettingsController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("profileSettings.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean Ucheck = false;
        boolean Pcheck = false;
        boolean PTcheck = false;
        User user = SessionHelper.getUserFromSession(request.getSession());
        String displayName = request.getParameter("name");
        String DOB = request.getParameter("dob");
        String hobbies = request.getParameter("hobbies");
        String photofile = request.getParameter("photo");
        String photoTitle = request.getParameter("photoTitle");
        PhotoDAO photoDAO = new PhotoDAO();
        if (!photofile.isEmpty()) {
            Pcheck = photoDAO.editUserPhotoByUserID(photofile, user.getID());
        } else {
            Pcheck = true;
        }
        UserDAO userDAO = new UserDAO();
        PTcheck = photoDAO.editUserPhotoTitleByUserID(photoTitle, user.getID());
        Ucheck = userDAO.editProfileByuserID(user.getID(), displayName, DOB, hobbies);
        if (Ucheck && Pcheck && PTcheck) {
            user.setDisplayname(displayName);
            PrintWriter out = response.getWriter();
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
            request.getRequestDispatcher("profileSettings.jsp").include(request, response);
            //response.sendRedirect("profileSettings?uid=" +user.getID());
        } else {
        }
    }

}
