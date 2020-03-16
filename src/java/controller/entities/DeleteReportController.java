/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.ReportDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hongq
 */
public class DeleteReportController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rid = request.getParameter("rid");
            ReportDAO reportDAO = new ReportDAO();
            boolean check = reportDAO.deleteReportByReportID(rid);
            if (check) {
                response.sendRedirect("admin");
            }else{
                
            }
        } catch (Exception ex) {
            Logger.getLogger(DeleteReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
