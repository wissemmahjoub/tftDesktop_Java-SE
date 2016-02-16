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
public class Actualite {
    
    private int idactualite;
    private String sujet;
    private Date datepublication;
    private Date datedestruction;

    public Actualite() {
    }

    public Actualite(int idactualite, String sujet, Date datepublication, Date datedestruction) {
        this.idactualite = idactualite;
        this.sujet = sujet;
        this.datepublication = datepublication;
        this.datedestruction = datedestruction;
    }

    public int getIdactualite() {
        return idactualite;
    }

    public void setIdactualite(int idactualite) {
        this.idactualite = idactualite;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public Date getDatedestruction() {
        return datedestruction;
    }

    public void setDatedestruction(Date datedestruction) {
        this.datedestruction = datedestruction;
    }

    @Override
    public String toString() {
        return "Actualite{" + "idactualite=" + idactualite + ", sujet=" + sujet + ", datepublication=" + datepublication + ", datedestruction=" + datedestruction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idactualite;
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
        final Actualite other = (Actualite) obj;
        if (this.idactualite != other.idactualite) {
            return false;
        }
        return true;
    }
    
    
    
    
}
