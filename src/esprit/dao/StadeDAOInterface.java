/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import java.sql.SQLException;

/**
 *
 * @author yasmi
 * @param <Stade>
 */
public interface StadeDAOInterface<Stade> extends ICrudDAO<Stade>{
   
        public Integer find(String t) throws SQLException;
        public String exists (int t) throws SQLException;
}
