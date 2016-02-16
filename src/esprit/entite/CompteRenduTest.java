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
public class CompteRenduTest {
    
    private int idtest;
    private int idmedecin;
    private int libelle;
    private Date datecreation;
    private String contenu;

    public CompteRenduTest() {
    }

    public CompteRenduTest(int idtest, int idmedecin, int libelle, Date datecreation, String contenu) {
        this.idtest = idtest;
        this.idmedecin = idmedecin;
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

    public int getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(int idmedecin) {
        this.idmedecin = idmedecin;
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
        return "CompteRenduTest{" + "idtest=" + idtest + ", idmedecin=" + idmedecin + ", libelle=" + libelle + ", datecreation=" + datecreation + ", contenu=" + contenu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idtest;
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
        final CompteRenduTest other = (CompteRenduTest) obj;
        if (this.idtest != other.idtest) {
            return false;
        }
        return true;
    }
    
    
    
}
