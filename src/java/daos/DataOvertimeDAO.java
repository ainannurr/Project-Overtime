/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.DataOvertime;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class DataOvertimeDAO {
    
    private final FunctionDAO fdao;

    public DataOvertimeDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    /**
     * Fungsi yang digunakan untuk menambahkan data dari overtime
     * @param dataOvertime
     * @return boolean true/false
     */
    public boolean insertOrUpdate(DataOvertime dataOvertime){
        return this.fdao.insertOrUpdate(dataOvertime);
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data overtime
     * @return List
     */
    public List<Object> getAll(){
        return this.fdao.get("FROM Data_overtime");
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data overtime
     * @param category - what column we will find
     * @param data - what we will find
     * @return List
     */
    public List<Object> search(String category, String data){
        return  this.fdao.get("FROM Data_overtime WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data overtime berdasarkan Id
     * @param dataId
     * @return 
     */
    public DataOvertime getJobById(String dataId){
        return (DataOvertime) this.fdao.getById("FROM Data_overtime WHERE id ='" +dataId+ "'");
    }
}
