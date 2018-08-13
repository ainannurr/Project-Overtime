/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.RoleController;
import entities.Role;

/**
 *
 * @author AINAN
 */
public class Tester {
    public static void main(String[] args) {
        
        RoleController rc = new RoleController(HibernateUtil.getSessionFactory());
        
        System.out.println(rc.saveOrEdit("R02", "Manager"));
    }
}
