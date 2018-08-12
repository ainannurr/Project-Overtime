/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoleDAO;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class RoleController {
    
    private final RoleDAO rdao;

    public RoleController(SessionFactory factory) {
        this.rdao = new RoleDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String nama) {
        Role role = new Role(id, nama);
        return this.rdao.insertOrUpdate(role);
    }

    private List<Role> convertToListJob(List<Object> dataAwal) {
        List<Role> dataRole = new ArrayList<>();
        for (Object object : dataAwal) {
            Role role = (Role)object;
            dataRole.add(role);
        }
        return dataRole;
    }
    
    public List<Role> getAll() {
        return this.convertToListJob(this.rdao.getAll());
    }

    public List<Role> search(String category, String data) {
        return this.convertToListJob(this.rdao.search(category, data));
    }
    
    public Role getById(String jobId){
        return this.rdao.getJobById(jobId);
    }
}
