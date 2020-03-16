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
public class Poster {
    private String ID;
    private String PostName;
    private User User;
    private String Image;
    private String Text;
    private Date PostingDate;

    public Poster() {
    }

    public Poster(String ID, String PostName, User User, String Image, String Text, Date PostingDate) {
        this.ID = ID;
        this.PostName = PostName;
        this.User = User;
        this.Image = Image;
        this.Text = Text;
        this.PostingDate = PostingDate;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String PostName) {
        this.PostName = PostName;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public Date getPostingDate() {
        return PostingDate;
    }

    public void setPostingDate(Date PostingDate) {
        this.PostingDate = PostingDate;
    }
    
}
