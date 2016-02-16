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
public class Score {
    
    private int idscore;
    private int nbrsetj1;
    private int nbrsetj2;
    private int nbracej1;
    private int nbracej2;
    private int dblfautej1;
    private int dblfautej2;

    public Score() {
    }

    public Score(int idscore, int nbrsetj1, int nbrsetj2, int nbracej1, int nbracej2, int dblfautej1, int dblfautej2) {
        this.idscore = idscore;
        this.nbrsetj1 = nbrsetj1;
        this.nbrsetj2 = nbrsetj2;
        this.nbracej1 = nbracej1;
        this.nbracej2 = nbracej2;
        this.dblfautej1 = dblfautej1;
        this.dblfautej2 = dblfautej2;
    }

    public int getIdscore() {
        return idscore;
    }

    public void setIdscore(int idscore) {
        this.idscore = idscore;
    }

    public int getNbrsetj1() {
        return nbrsetj1;
    }

    public void setNbrsetj1(int nbrsetj1) {
        this.nbrsetj1 = nbrsetj1;
    }

    public int getNbrsetj2() {
        return nbrsetj2;
    }

    public void setNbrsetj2(int nbrsetj2) {
        this.nbrsetj2 = nbrsetj2;
    }

    public int getNbracej1() {
        return nbracej1;
    }

    public void setNbracej1(int nbracej1) {
        this.nbracej1 = nbracej1;
    }

    public int getNbracej2() {
        return nbracej2;
    }

    public void setNbracej2(int nbracej2) {
        this.nbracej2 = nbracej2;
    }

    public int getDblfautej1() {
        return dblfautej1;
    }

    public void setDblfautej1(int dblfautej1) {
        this.dblfautej1 = dblfautej1;
    }

    public int getDblfautej2() {
        return dblfautej2;
    }

    public void setDblfautej2(int dblfautej2) {
        this.dblfautej2 = dblfautej2;
    }

    @Override
    public String toString() {
        return "Score{" + "idscore=" + idscore + ", nbrsetj1=" + nbrsetj1 + ", nbrsetj2=" + nbrsetj2 + ", nbracej1=" + nbracej1 + ", nbracej2=" + nbracej2 + ", dblfautej1=" + dblfautej1 + ", dblfautej2=" + dblfautej2 + '}';
    }

    public Score(int idscore) {
        this.idscore = idscore;
    }

    
    
}
