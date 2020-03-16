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
public class Topic {
    private String ID;
    private String Text;

    public Topic() {
    }

    public Topic(String ID, String Text) {
        this.ID = ID;
        this.Text = Text;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }
    
}
