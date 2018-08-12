/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.StatusOvertime;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class StatusOvertimeDAO {
    
    private final FunctionDAO fdao;

    public StatusOvertimeDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    /**
     * Fungsi yang digunakan untuk menambahkan data Status pada Overtime
     * @param overtime atau status overtime
     * @return boolean true/false
     */
    public boolean insertOrUpdate(StatusOvertime overtime){
        return this.fdao.insertOrUpdate(overtime);
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data status pada overtime
     * @return List
     */
    public List<Object> getAll(){
        return this.fdao.get("FROM Status_overtime");
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data status overtime
     * @param category - what column we will find
     * @param data - what we will find
     * @return List
     */
    public List<Object> search(String category, String data){
        return  this.fdao.get("FROM Status_overtime WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data status overtime berdasarkan Id
     * @param statusId
     * @return 
     */
    public StatusOvertime getJobById(String statusId){
        return (StatusOvertime) this.fdao.getById("FROM Status_overtime WHERE id ='" +statusId+ "'");
    }
}
