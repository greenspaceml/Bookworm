/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import controller.auth.Deauthentication;
import dal.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Report;
import models.User;
import until.CookieHelper;
import until.SessionHelper;

/**
 *
 * @author hongq
 */
public class AdminController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionHelper sessionHelper = new SessionHelper();

        User user = sessionHelper.getUserFromSession(request.getSession());
        if (user.isAccountType()) {
            try {
                ReportDAO reportDAO = new ReportDAO();
                ArrayList<Report> listReport = reportDAO.getReports();
                String rid = request.getParameter("rid");
                if (rid == null || rid.isEmpty()) {
                    rid = reportDAO.getFirstReportID();
                }
                Report instanceReport = reportDAO.getReportByReportID(rid);
                request.setAttribute("listReport", listReport);
                request.setAttribute("instanceReport", instanceReport);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            SessionHelper.addUserToSession(request.getSession(), null);
            CookieHelper.removeCookie(response, "username");
            CookieHelper.removeCookie(response, "password");
            response.sendRedirect("login");
        }

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
