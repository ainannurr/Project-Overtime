/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Role;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class RoleDAO {
    
    private final FunctionDAO fdao;

    public RoleDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    /**
     * Fungsi yang digunakan untuk menambahkan data Role
     * @param role
     * @return boolean true/false
     */
    public boolean insertOrUpdate(Role role){
        return this.fdao.insertOrUpdate(role);
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data Role
     * @return List
     */
    public List<Object> getAll(){
        return this.fdao.get("FROM Role");
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data Job
     * @param category - what column we will find
     * @param data - what we will find
     * @return List
     */
    public List<Object> search(String category, String data){
        return  this.fdao.get("FROM Role WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data Job berdasarkan Id
     * @param roleId
     * @return 
     */
    public Role getJobById(String roleId){
        return (Role) this.fdao.getById("FROM Role WHERE id ='" +roleId+ "'");
    }
}
