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
public class Participation {
    
    private int idsession;
    private int idparticipant;
    private Date dateenvoi;

    public Participation() {
    }

    public Participation(int idsession, int idparticipant, Date dateenvoi) {
        this.idsession = idsession;
        this.idparticipant = idparticipant;
        this.dateenvoi = dateenvoi;
    }

    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public int getIdparticipant() {
        return idparticipant;
    }

    public void setIdparticipant(int idparticipant) {
        this.idparticipant = idparticipant;
    }

    public Date getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(Date dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    @Override
    public String toString() {
        return "Participation{" + "idsession=" + idsession + ", idparticipant=" + idparticipant + ", dateenvoi=" + dateenvoi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idsession;
        hash = 67 * hash + this.idparticipant;
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
        final Participation other = (Participation) obj;
        if (this.idsession != other.idsession) {
            return false;
        }
        if (this.idparticipant != other.idparticipant) {
            return false;
        }
        return true;
    }
    
    
    

}
