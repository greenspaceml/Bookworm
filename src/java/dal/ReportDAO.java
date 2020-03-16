/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Poster;
import models.Report;
import models.User;

/**
 *
 * @author hongq
 */
public class ReportDAO extends DBContext {

    public boolean reportToAdmin(String ID, String UserID, String PostID, String reportName, String reportText, String reportDate) {
        int check = 0;
        try {
            String sql = " insert into Report (ID,UserID,PostID,Content,Text,ReportDate) values\n"
                    + " (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            ps.setString(2, UserID);
            ps.setString(3, PostID);
            ps.setString(4, reportName);
            ps.setString(5, reportText);
            ps.setString(6, reportDate);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check > 0;
    }

    public ArrayList<Report> getReports() {
        ArrayList<Report> listReport = new ArrayList<>();
        try {
            String sql = " select * from Report order by ReportDate desc ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Report r = new Report();
                r.setID(rs.getString("ID"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                r.setUser(u);
                Poster p = new Poster();
                p.setID(rs.getString("PostID"));
                r.setPoster(p);
                r.setContent(rs.getString("Content"));
                r.setText(rs.getString("Text"));
                r.setReportDate(rs.getString("ReportDate"));
                listReport.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReport;
    }

    public Report getReportByReportID(String reportID) {
        Report r = new Report();
        try {
            String sql = " select * from Report r Where r.ID = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, reportID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r.setID(rs.getString("ID"));
                User u = new User();
                u.setID(rs.getString("UserID"));
                r.setUser(u);
                Poster p = new Poster();
                p.setID(rs.getString("PostID"));
                r.setPoster(p);
                r.setContent(rs.getString("Content"));
                r.setText(rs.getString("Text"));
                r.setReportDate(rs.getString("ReportDate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String getFirstReportID() {
        String id = null;
        try {
            String sql = " Select Top(1) r.ID\n"
                    + " from Report r";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int getReportCountByPostID(String ID) {
        int count = 0;
        try {
            String sql = "  select count(r.ID) as N\n"
                    + "  From Report r\n"
                    + "  where r.PostID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public boolean deleteReportByPostID(String ID) {
        int check = 0;
        try {
            String sql = "  delete from Report\n"
                    + "  where PostID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
    
    public boolean deleteReportByReportID(String ID) {
        int check = 0;
        try {
            String sql = "  delete from Report\n"
                    + "  where ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
