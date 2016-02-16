/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entite;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author yasmi
 */
public class Match {
    
    private int idmatch;
    private String codematch;
    private int idjoueur1;
    private int idjoueur2;
    private int idcompetition;
    private int idarbitre;
    private int idevenement;
    private String lieu;
    private Timestamp datematch;
    private Niveau niveau; //enumeration
    private TrancheAge type; //enumeration
    private int idscore;
    private int idticket;



    
}
