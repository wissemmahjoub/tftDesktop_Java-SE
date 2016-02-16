/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.util.Date;

/**
 *
 * @author yasmi
 */
public class Reclamation {
    
    private int idreclamation;
    private String sujet;
    private String path;
    private Date datecreation;
    private Date datedestrction;
    private int idpersonne;

    public Reclamation() {
    }

    public Reclamation(int idreclamation, String sujet, String path, Date datecreation, Date datedestrction, int idpersonne) {
        this.idreclamation = idreclamation;
        this.sujet = sujet;
        this.path = path;
        this.datecreation = datecreation;
        this.datedestrction = datedestrction;
        this.idpersonne = idpersonne;
    }

    public int getIdreclamation() {
        return idreclamation;
    }

    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatedestrction() {
        return datedestrction;
    }

    public void setDatedestrction(Date datedestrction) {
        this.datedestrction = datedestrction;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idreclamation=" + idreclamation + ", sujet=" + sujet + ", path=" + path + ", datecreation=" + datecreation + ", datedestrction=" + datedestrction + ", idpersonne=" + idpersonne + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idreclamation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.idreclamation != other.idreclamation) {
            return false;
        }
        return true;
    }
    
    
    
    
}
