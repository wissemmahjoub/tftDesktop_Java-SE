/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yasmi
 */
public class SessionFormation {
    
    private int idsession;
    private String libelesession;
    private String lieu;
    private Date datedebut;
    private Date datefin;
    private Date datedestruction;
    private Cible cible;
    private Niveau niveau;
    private int capacite;

    public SessionFormation() {
    }

    public SessionFormation(int idsession, String libelesession, String lieu, Date datedebut, Date datefin, Date datedestruction, Cible cible, Niveau niveau, int capacite) {
        this.idsession = idsession;
        this.libelesession = libelesession;
        this.lieu = lieu;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.datedestruction = datedestruction;
        this.cible = cible;
        this.niveau = niveau;
        this.capacite = capacite;
    }

    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public String getLibelesession() {
        return libelesession;
    }

    public void setLibelesession(String libelesession) {
        this.libelesession = libelesession;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Date getDatedestruction() {
        return datedestruction;
    }

    public void setDatedestruction(Date datedestruction) {
        this.datedestruction = datedestruction;
    }

    public Cible getCible() {
        return cible;
    }

    public void setCible(Cible cible) {
        this.cible = cible;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "SessionFormation{" + "idsession=" + idsession + ", libelesession=" + libelesession + ", lieu=" + lieu + ", datedebut=" + datedebut + ", datefin=" + datefin + ", datedestruction=" + datedestruction + ", cible=" + cible + ", niveau=" + niveau + ", capacite=" + capacite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idsession;
        hash = 67 * hash + Objects.hashCode(this.libelesession);
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
        final SessionFormation other = (SessionFormation) obj;
        if (this.idsession != other.idsession) {
            return false;
        }
        if (!Objects.equals(this.libelesession, other.libelesession)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
