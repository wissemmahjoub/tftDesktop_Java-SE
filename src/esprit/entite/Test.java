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
public class Test {
    
    private String idtest;
    private String libelletest;
    private Date datetest;

    public Test() {
    }

    public Test(String idtest, String libelletest, Date datetest) {
        this.idtest = idtest;
        this.libelletest = libelletest;
        this.datetest = datetest;
    }

    public String getIdtest() {
        return idtest;
    }

    public void setIdtest(String idtest) {
        this.idtest = idtest;
    }

    public String getLibelletest() {
        return libelletest;
    }

    public void setLibelletest(String libelletest) {
        this.libelletest = libelletest;
    }

    public Date getDatetest() {
        return datetest;
    }

    public void setDatetest(Date datetest) {
        this.datetest = datetest;
    }

    @Override
    public String toString() {
        return "Test{" + "idtest=" + idtest + ", libelletest=" + libelletest + ", datetest=" + datetest + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idtest);
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
        final Test other = (Test) obj;
        if (!Objects.equals(this.idtest, other.idtest)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
