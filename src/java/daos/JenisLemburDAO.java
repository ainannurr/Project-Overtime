/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.JenisLembur;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class JenisLemburDAO {
    
    private final FunctionDAO fdao;

    public JenisLemburDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    /**
     * Fungsi yang digunakan untuk menambahkan dan mengedit data Jenis Lembur
     * @param jenisLembur
     * @return boolean true/false
     */
    public boolean insertOrUpdate(JenisLembur jenisLembur){
        return this.fdao.insertOrUpdate(jenisLembur);
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data jenis lembur
     * @return List
     */
    public List<Object> getAll(){
        return this.fdao.get("FROM Jenis_lembur");
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data jenis lembur
     * @param category - what column we will find
     * @param data - what we will find
     * @return List
     */
    public List<Object> search(String category, String data){
        return  this.fdao.get("FROM Jenis_lembur WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data jenis lembur berdasarkan Id
     * @param roleId
     * @return 
     */
    public JenisLembur getJobById(String jenisId){
        return (JenisLembur) this.fdao.getById("FROM Jenis_lembur WHERE id_jenis_lembur ='" +jenisId+ "'");
    }
}
