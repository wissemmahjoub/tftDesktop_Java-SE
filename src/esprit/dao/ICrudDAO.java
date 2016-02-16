/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.dao;

import java.util.List;

/**
 *
 * @author Mustapha
 */
public interface ICrudDAO <T>{
    public void save(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> getList();
}
