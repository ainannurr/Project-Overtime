/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Karyawan;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class KaryawanDAO {
    
    private final FunctionDAO fdao;

    public KaryawanDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    /**
     * Fungsi yang digunakan untuk menambahkan dan mengedit data karyawan
     * @param karyawan
     * @return boolean true/false
     */
    public boolean insertOrUpdate(Karyawan karyawan){
        return this.fdao.insertOrUpdate(karyawan);
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data status pada overtime
     * @return List
     */
    public List<Object> getAllSort(String category,String sort){
        return this.fdao.get("FROM Karyawan ORDER BY "+category+" "+sort);
    }
    
    /**
     * Fungsi yang digunakan untuk mencari data status overtime
     * @param category - what column we will find
     * @param data - what we will find
     * @return List
     */
    public List<Object> search(String category, String data){
        return  this.fdao.get("FROM Karyawan WHERE " +category+ " LIKE '%" +data+ "%'");
    }
    
    /**
     * Fungsi yang digunakan untuk mendapatkan data status overtime berdasarkan Id
     * @param karyawanId
     * @return 
     */
    public Karyawan getJobById(String karyawanId){
        return (Karyawan) this.fdao.getById("FROM Karyawan WHERE id ='" +karyawanId+ "'");
    }
}
