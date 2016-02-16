/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

/**
 *
 * @author yasmi
 */
public class Classement {
    
    private int idjoueur;
    private int idcomptetition;
    private int rang;

    public Classement() {
    }

    public Classement(int idjoueur, int idcomptetition, int rang) {
        this.idjoueur = idjoueur;
        this.idcomptetition = idcomptetition;
        this.rang = rang;
    }

    public int getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
    }

    public int getIdcomptetition() {
        return idcomptetition;
    }

    public void setIdcomptetition(int idcomptetition) {
        this.idcomptetition = idcomptetition;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    @Override
    public String toString() {
        return "Classement{" + "idjoueur=" + idjoueur + ", idcomptetition=" + idcomptetition + ", rang=" + rang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idjoueur;
        hash = 37 * hash + this.idcomptetition;
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
        final Classement other = (Classement) obj;
        if (this.idjoueur != other.idjoueur) {
            return false;
        }
        if (this.idcomptetition != other.idcomptetition) {
            return false;
        }
        return true;
    }
    
    
    
    
}
