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
public class Photo {
    private String ID;
    private String Photoname;
    private String Tittle;

    public Photo() {
    }

    public Photo(String ID, String Photoname, String Tittle) {
        this.ID = ID;
        this.Photoname = Photoname;
        this.Tittle = Tittle;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhotoname() {
        return Photoname;
    }

    public void setPhotoname(String Photoname) {
        this.Photoname = Photoname;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    @Override
    public String toString() {
        return "Photo{" + "ID=" + ID + ", Photoname=" + Photoname + ", Tittle=" + Tittle + '}';
    }
    
    
    
}
