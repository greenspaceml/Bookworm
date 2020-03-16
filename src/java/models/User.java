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
public class User {
    private String ID;
    private boolean AccountType;
    private String Username;
    private String Password;
    private String Displayname;
    private Date DateOfBirth;
    private String Hobbies;

    public User() {
    }

    public User(String ID, boolean AccountType, String Username, String Password, String Displayname, Date DateOfBirth, String Hoobies) {
        this.ID = ID;
        this.AccountType = AccountType;
        this.Username = Username;
        this.Password = Password;
        this.Displayname = Displayname;
        this.DateOfBirth = DateOfBirth;
        this.Hobbies = Hoobies;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isAccountType() {
        return AccountType;
    }

    public void setAccountType(boolean AccountType) {
        this.AccountType = AccountType;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDisplayname() {
        return Displayname;
    }

    public void setDisplayname(String Displayname) {
        this.Displayname = Displayname;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String Hobbies) {
        this.Hobbies = Hobbies;
    }


    
    
}
