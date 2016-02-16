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
public class Ticket {
    
    private int idticket;
    private int nbrticket;
    private int idmatch;
    private float prix;

    public Ticket() {
    }

    public Ticket(int idticket, int nbrticket, int idmatch, float prix) {
        this.idticket = idticket;
        this.nbrticket = nbrticket;
        this.idmatch = idmatch;
        this.prix = prix;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public int getNbrticket() {
        return nbrticket;
    }

    public void setNbrticket(int nbrticket) {
        this.nbrticket = nbrticket;
    }

    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idticket=" + idticket + ", nbrticket=" + nbrticket + ", idmatch=" + idmatch + ", prix=" + prix + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idticket;
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
        final Ticket other = (Ticket) obj;
        if (this.idticket != other.idticket) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
