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
public class Achat {
    
    private int idmembre;
    private int idticket;
    private Date dateachat;

    public Achat() {
    }

    public Achat(int idmembre, int idticket, Date dateachat) {
        this.idmembre = idmembre;
        this.idticket = idticket;
        this.dateachat = dateachat;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public Date getDateachat() {
        return dateachat;
    }

    public void setDateachat(Date dateachat) {
        this.dateachat = dateachat;
    }

    @Override
    public String toString() {
        return "Achat{" + "idmembre=" + idmembre + ", idticket=" + idticket + ", dateachat=" + dateachat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idmembre;
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
        final Achat other = (Achat) obj;
        if (this.idmembre != other.idmembre) {
            return false;
        }
        return true;
    }
    
    
    
}
