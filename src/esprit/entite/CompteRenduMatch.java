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
public class CompteRenduMatch {
    
    private int idtest;
    private int idarbitre;
    private int libelle;
    private Date datecreation;
    private String contenu;

    public CompteRenduMatch() {
    }

    public CompteRenduMatch(int idtest, int idarbitre, int libelle, Date datecreation, String contenu) {
        this.idtest = idtest;
        this.idarbitre = idarbitre;
        this.libelle = libelle;
        this.datecreation = datecreation;
        this.contenu = contenu;
    }

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    public int getIdarbitre() {
        return idarbitre;
    }

    public void setIdarbitre(int idarbitre) {
        this.idarbitre = idarbitre;
    }

    public int getLibelle() {
        return libelle;
    }

    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "CompteRenduMatch{" + "idtest=" + idtest + ", idarbitre=" + idarbitre + ", libelle=" + libelle + ", datecreation=" + datecreation + ", contenu=" + contenu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idtest;
        hash = 89 * hash + this.idarbitre;
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
        final CompteRenduMatch other = (CompteRenduMatch) obj;
        if (this.idtest != other.idtest) {
            return false;
        }
        if (this.idarbitre != other.idarbitre) {
            return false;
        }
        return true;
    }

    
    
}
