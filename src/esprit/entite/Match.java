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
    private String nomj1;
    private String prenomj1;
    private String nomj2;
    private String prenomj2;
    private String nomArb;
    private String prenomArb;
    private String libellestade;
    private String libellecompetition;
    private String libelleevennement;
    private int nombreTicket;
    private int prixTicket;
    public Match() {
    }

    public int getNombreTicket() {
        return nombreTicket;
    }

    public void setNombreTicket(int nombreTicket) {
        this.nombreTicket = nombreTicket;
    }

    public int getPrixTicket() {
        return prixTicket;
    }

    public void setPrixTicket(int prixTicket) {
        this.prixTicket = prixTicket;
    }

    public String getLibelleevennement() {
        return libelleevennement;
    }

    public void setLibelleevennement(String libelleevennement) {
        this.libelleevennement = libelleevennement;
    }

    public String getNomj1() {
        return nomj1;
    }

    public String getLibellecompetition() {
        return libellecompetition;
    }

    public void setLibellecompetition(String libellecompetition) {
        this.libellecompetition = libellecompetition;
    }

    public void setNomj1(String nomj1) {
        this.nomj1 = nomj1;
    }

    public String getPrenomj1() {
        return prenomj1;
    }

    public void setPrenomj1(String prenomj1) {
        this.prenomj1 = prenomj1;
    }

    public String getNomj2() {
        return nomj2;
    }

    public void setNomj2(String nomj2) {
        this.nomj2 = nomj2;
    }

    public String getPrenomj2() {
        return prenomj2;
    }

    public void setPrenomj2(String prenomj2) {
        this.prenomj2 = prenomj2;
    }

    public String getNomArb() {
        return nomArb;
    }

    public void setNomArb(String nomArb) {
        this.nomArb = nomArb;
    }

    public String getPrenomArb() {
        return prenomArb;
    }

    public void setPrenomArb(String prenomArb) {
        this.prenomArb = prenomArb;
    }

    public String getLibellestade() {
        return libellestade;
    }

    public void setLibellestade(String libellestade) {
        this.libellestade = libellestade;
    }


    public Match(int idmatch, String libellecompetition,String nomj1, String nomj2, String nomArb, String libellestade, Date datematch) {
        this.idmatch = idmatch;
        this.libellecompetition = libellecompetition;
        this.datematch = datematch;
        this.nomj1 = nomj1;
        this.nomj2 = nomj2;
        this.nomArb = nomArb;
        this.libellestade = libellestade;
    
    }
 
    
       
    public Match(int idmatch,TrancheAge type, Niveau niveau, Categorie categorie, int idticket,String libellecompetition,String nomj1,  String nomj2, String nomArb,String libellestade,Date datematch,int nbticket,int prixticket) {
        this.idmatch = idmatch;
        this.type=type;
        this.niveau=niveau;
        this.categorie=categorie;
        this.idticket=idticket;
        this.libellecompetition=libellecompetition;
        this.nomj1 = nomj1;
        this.nomj2 = nomj2;
        this.nomArb = nomArb;
        this.libellestade = libellestade;
        this.datematch=  datematch;
        this.nombreTicket=nbticket;
        this.prixTicket=prixticket;        
    }

    
        public Match(int idmatch,TrancheAge type, Niveau niveau, Categorie categorie,String nomj1,  String nomj2, String nomArb,String libelleevennement,String libellestade,Date datematch) {
        this.idmatch = idmatch;
        this.type=type;
        this.niveau=niveau;
        this.categorie=categorie;
        this.nomj1=nomj1;
        this.nomj2=nomj2;
        this.nomArb=nomArb;
        this.libelleevennement=libelleevennement;
        this.libellestade=libellestade;
        this.datematch=datematch;
    }
    
//    public Match(int idmatch,TrancheAge type, Niveau niveau, Categorie categorie, int idticket,String nomj1,  String nomj2, String nomArb, String libelleevennement,String libellestade,Date datematch,int nbticket,int prixticket) {
//        this.idmatch = idmatch;
//        this.type=type;
//        this.niveau=niveau;
//        this.categorie=categorie;
//        this.idticket=idticket;
//
//        this.nomj1 = nomj1;
//        this.nomj2 = nomj2;
//        this.nomArb = nomArb;
//        this.libelleevennement=libelleevennement;
//        this.libellestade = libellestade;
//        this.datematch=  datematch;
//        this.nombreTicket=nbticket;
//        this.prixTicket=prixticket;        
//    }


    public Match(int idmatch, int idjoueur1, int idjoueur2, int idcompetition, int idarbitre, int idevenement, int idstade, Date datematch, Niveau niveau, TrancheAge type, Categorie categorie, int idscore, int idticket, String nomj1, String prenomj1, String nomj2, String prenomj2, String nomArb, String prenomArb, String libellestade, String libellecompetition,int nbticket,int prixticket) {
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
        this.categorie = categorie;
        this.idscore = idscore;
        this.idticket = idticket;
        this.nomj1 = nomj1;
        this.prenomj1 = prenomj1;
        this.nomj2 = nomj2;
        this.prenomj2 = prenomj2;
        this.nomArb = nomArb;
        this.prenomArb = prenomArb;
        this.libellestade = libellestade;
        this.libellecompetition = libellecompetition;
        this.nombreTicket=nbticket;
        this.prixTicket=prixticket;
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

    public Match(int idjoueur1, int idjoueur2, int idcompetition, int idarbitre, int idstade, Date datematch, Niveau niveau, TrancheAge type, Categorie categorie, int idscore, int idticket) {
        this.idjoueur1 = idjoueur1;
        this.idjoueur2 = idjoueur2;
        this.idcompetition = idcompetition;
        this.idarbitre = idarbitre;
        this.idstade = idstade;
        this.datematch = datematch;
        this.niveau = niveau;
        this.type = type;
        this.categorie = categorie;
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
        return "Match{" + "idmatch=" + idmatch + ", idjoueur1=" + idjoueur1 + ", idjoueur2=" + idjoueur2 + ", idcompetition=" + idcompetition + ", idarbitre=" + idarbitre + ", idevenement=" + idevenement + ", idstade=" + idstade + ", datematch=" + datematch + ", niveau=" + niveau + ", type=" + type + ", categorie=" + categorie + ", idscore=" + idscore + ", idticket=" + idticket + ", nomj1=" + nomj1 + ", prenomj1=" + prenomj1 + ", nomj2=" + nomj2 + ", prenomj2=" + prenomj2 + ", nomArb=" + nomArb + ", prenomArb=" + prenomArb + ", libellestade=" + libellestade + ", libellecompetition=" + libellecompetition + ", nombreTicket=" + nombreTicket + ", prixTicket=" + prixTicket + '}';
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
