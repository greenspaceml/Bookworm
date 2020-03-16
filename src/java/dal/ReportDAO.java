/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
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

    public boolean reportToAdmin(String ID, String UserID, String PostID, String reportName, String reportText, String reportDate) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " insert into Report (ID,UserID,PostID,Content,Text,ReportDate) values\n"
                    + " (?,?,?,?,?,?)";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            ps.setString(2, UserID);
            ps.setString(3, PostID);
            ps.setString(4, reportName);
            ps.setString(5, reportText);
            ps.setString(6, reportDate);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }

        return check > 0;
    }

    public ArrayList<Report> getReports() throws Exception {
        ArrayList<Report> listReport = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " select * from Report order by ReportDate desc ";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listReport;
    }

    public Report getReportByReportID(String reportID) throws Exception {
        Report r = new Report();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " select * from Report r Where r.ID = ? ";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, reportID);
            rs = ps.executeQuery();
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
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return r;
    }

    public String getFirstReportID() throws Exception {
        String id = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = " Select Top(1) r.ID\n"
                    + " from Report r";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return id;
    }

    public int getReportCountByPostID(String ID) throws Exception {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  select count(r.ID) as N\n"
                    + "  From Report r\n"
                    + "  where r.PostID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("N");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return count;
    }

    public boolean deleteReportByPostID(String ID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  delete from Report\n"
                    + "  where PostID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public boolean deleteReportByReportID(String ID) throws Exception {
        int check = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext dBContext = new DBContext();
        try {
            String sql = "  delete from Report\n"
                    + "  where ID = ?";
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }
}
