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
public class Stade {
    
    private int idstade;
    private String libellestade;
    private String avatar;
    private String latitude;
    private String longidute;
    private String ville;
    private int capacite;
    private Surface surface;
    private Date datecreation;
    private Date datedestruction;

    public Stade() {
    }

    public Stade(int idstade, String libellestade, String avatar, String latitude, String longidute, String ville, int capacite, Surface surface, Date datecreation, Date datedestruction) {
        this.idstade = idstade;
        this.libellestade = libellestade;
        this.avatar = avatar;
        this.latitude = latitude;
        this.longidute = longidute;
        this.ville = ville;
        this.capacite = capacite;
        this.surface = surface;
        this.datecreation = datecreation;
        this.datedestruction = datedestruction;
    }
    
    
    public int getIdstade() {
        return idstade;
    }

    public void setIdstade(int idstade) {
        this.idstade = idstade;
    }

    public String getLibellestade() {
        return libellestade;
    }

    public void setLibellestade(String libellestade) {
        this.libellestade = libellestade;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongidute() {
        return longidute;
    }

    public void setLongidute(String longidute) {
        this.longidute = longidute;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatedestruction() {
        return datedestruction;
    }

    public void setDatedestruction(Date datedestruction) {
        this.datedestruction = datedestruction;
    }

    @Override
    public String toString() {
        return "Stade{" + "idstade=" + idstade + ", libellestade=" + libellestade + ", avatar=" + avatar + ", latitude=" + latitude + ", longidute=" + longidute + ", ville=" + ville + ", capacite=" + capacite + ", surface=" + surface + ", datecreation=" + datecreation + ", datedestruction=" + datedestruction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idstade;
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
        final Stade other = (Stade) obj;
        if (this.idstade != other.idstade) {
            return false;
        }
        return true;
    }
    
    
    
}
