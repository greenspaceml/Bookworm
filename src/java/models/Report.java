/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hongq
 */
public class Report {
    private String ID;
    private User User;
    private Poster Poster;
    private String Content;
    private String text;
    private String ReportDate;

    public Report() {
    }

    public Report(String ID, User User, Poster Poster, String Content, String text, String ReportDate) {
        this.ID = ID;
        this.User = User;
        this.Poster = Poster;
        this.Content = Content;
        this.text = text;
        this.ReportDate = ReportDate;
    }

    public String getReportDate() {
        return ReportDate;
    }

    public void setReportDate(String ReportDate) {
        this.ReportDate = ReportDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Poster getPoster() {
        return Poster;
    }

    public void setPoster(Poster Poster) {
        this.Poster = Poster;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
