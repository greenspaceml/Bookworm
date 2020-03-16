/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ReportController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            SessionHelper sessionHelper = new SessionHelper();
            ProcessSupport processSupport = new ProcessSupport();
            User user = sessionHelper.getUserFromSession(request.getSession());
            String posterID = request.getParameter("poid");
            String ReportName = request.getParameter("ReportName");
            String ReportText = request.getParameter("ReportText");
            String ID = "r" + processSupport.getCurrentDateForCommentID();
            String dateOfReport = processSupport.getCurrentDate();
            ReportDAO reportDAO = new ReportDAO();
            boolean check = reportDAO.reportToAdmin(ID, user.getID(), posterID, ReportName, ReportText, dateOfReport);
            if (check) {
                response.sendRedirect("list");
            } else {
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
