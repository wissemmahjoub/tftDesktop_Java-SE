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
    
    public T find(T t);
    public boolean save(T t);
    public boolean  delete(T t);
    public boolean  update(T t);
    public List<T> getList();
}
