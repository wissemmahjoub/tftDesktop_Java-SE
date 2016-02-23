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
public class Match {
    
    private int idmatch;
    private int idjoueur1;
    private int idjoueur2;
    private int idcompetition;
    private int idarbitre;
    private int idevenement;
    private int idstade;
    private Date datematch;
    private Niveau niveau; //enumeration
    private TrancheAge type; //enumeration
    private Categorie categorie;//enumeration
    private int idscore;
    private int idticket;
    

    public Match() {
    }

   

    public Match(int idmatch, int idjoueur1, int idjoueur2, int idcompetition, int idarbitre, int idevenement, int idstade, Date datematch, Niveau niveau, TrancheAge type, Categorie categorie,int idscore, int idticket) {
        this.idmatch = idmatch;
        this.idjoueur1 = idjoueur1;
        this.idjoueur2 = idjoueur2;
        this.idcompetition = idcompetition;
        this.idarbitre = idarbitre;
        this.idevenement = idevenement;
        this.idstade = idstade;
        this.datematch = datematch;
        this.niveau = niveau;
        this.type = type;
        this.categorie=categorie;
        this.idscore = idscore;
        this.idticket = idticket;
    }

   

  

    public int getIdstade() {
        return idstade;
    }

    public void setIdstade(int idstade) {
        this.idstade = idstade;
    }

    
    
    
    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
    }

    public int getIdjoueur1() {
        return idjoueur1;
    }

    public void setIdjoueur1(int idjoueur1) {
        this.idjoueur1 = idjoueur1;
    }

    public int getIdjoueur2() {
        return idjoueur2;
    }

    public void setIdjoueur2(int idjoueur2) {
        this.idjoueur2 = idjoueur2;
    }

    public int getIdcompetition() {
        return idcompetition;
    }

    public void setIdcompetition(int idcompetition) {
        this.idcompetition = idcompetition;
    }

    public int getIdarbitre() {
        return idarbitre;
    }

    public void setIdarbitre(int idarbitre) {
        this.idarbitre = idarbitre;
    }

    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }



    public Date getDatematch() {
        return datematch;
    }

    public void setDatematch(Date datematch) {
        this.datematch = datematch;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
 
    public TrancheAge getType() {
        return type;
    }

    public void setType(TrancheAge type) {
        this.type = type;
    }

    public int getIdscore() {
        return idscore;
    }

    public void setIdscore(int idscore) {
        this.idscore = idscore;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    @Override
    public String toString() {
        return "Match{" + "idmatch=" + idmatch + ", idjoueur1=" + idjoueur1 + ", idjoueur2=" + idjoueur2 + ", idcompetition=" + idcompetition + ", idarbitre=" + idarbitre + ", idevenement=" + idevenement + ", datematch=" + datematch + ", niveau=" + niveau + ", type=" + type + ", idscore=" + idscore + ", idticket=" + idticket + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idmatch;
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
        final Match other = (Match) obj;
        if (this.idmatch != other.idmatch) {
            return false;
        }
        return true;
    }

    

    
}
