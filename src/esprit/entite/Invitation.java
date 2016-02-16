/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.util.Objects;

/**
 *
 * @author yasmi
 */
public class Invitation {
    
    private String idjoueur;
    private String idtest;
    private String dateinvitation;

    public Invitation() {
    }

    public Invitation(String idjoueur, String idtest, String dateinvitation) {
        this.idjoueur = idjoueur;
        this.idtest = idtest;
        this.dateinvitation = dateinvitation;
    }

    public String getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(String idjoueur) {
        this.idjoueur = idjoueur;
    }

    public String getIdtest() {
        return idtest;
    }

    public void setIdtest(String idtest) {
        this.idtest = idtest;
    }

    public String getDateinvitation() {
        return dateinvitation;
    }

    public void setDateinvitation(String dateinvitation) {
        this.dateinvitation = dateinvitation;
    }

    @Override
    public String toString() {
        return "Invitation{" + "idjoueur=" + idjoueur + ", idtest=" + idtest + ", dateinvitation=" + dateinvitation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idjoueur);
        hash = 67 * hash + Objects.hashCode(this.idtest);
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
        final Invitation other = (Invitation) obj;
        if (!Objects.equals(this.idjoueur, other.idjoueur)) {
            return false;
        }
        if (!Objects.equals(this.idtest, other.idtest)) {
            return false;
        }
        return true;
    }

    
    
    
}
