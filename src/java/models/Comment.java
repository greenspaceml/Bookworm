/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author hongq
 */
public class Comment {
    private String ID;
    private Date CommentDate;
    private User User;
    private Poster Poster;
    private String Text;

    public Comment() {
    }

    public Comment(String ID, Date CommentDate, User User, Poster Poster, String Text) {
        this.ID = ID;
        this.CommentDate = CommentDate;
        this.User = User;
        this.Poster = Poster;
        this.Text = Text;
    }

    public Date getCommentDate() {
        return CommentDate;
    }

    public void setCommentDate(Date CommentDate) {
        this.CommentDate = CommentDate;
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

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }
    
}
