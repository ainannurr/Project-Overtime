/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author AINAN
 */
public interface InterfaceDAO {
    public boolean insertOrUpdate(Object object);
    public List<Object> get(String query);
    public Object getById(String query);
    public String getAutoId();
}
