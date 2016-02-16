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
public class Club {
    
    
    private int idclub;
    private String libellecode;
    private String avatar;
    private Date datecreation;
    private Date datedestruction;

    public Club() {
    }

    public Club(int idclub, String libellecode, String avatar, Date datecreation, Date datedestruction) {
        this.idclub = idclub;
        this.libellecode = libellecode;
        this.avatar = avatar;
        this.datecreation = datecreation;
        this.datedestruction = datedestruction;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public String getLibellecode() {
        return libellecode;
    }

    public void setLibellecode(String libellecode) {
        this.libellecode = libellecode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
        return "Club{" + "idclub=" + idclub + ", libellecode=" + libellecode + ", avatar=" + avatar + ", datecreation=" + datecreation + ", datedestruction=" + datedestruction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idclub;
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
        final Club other = (Club) obj;
        if (this.idclub != other.idclub) {
            return false;
        }
        return true;
    }
    
    

}
