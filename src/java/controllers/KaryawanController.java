/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.KaryawanDAO;
import entities.Karyawan;
import entities.Role;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class KaryawanController {
    
    private final KaryawanDAO kdao;

    public KaryawanController(SessionFactory factory) {
        this.kdao = new KaryawanDAO(factory);
    }
    
    public boolean saveOrEdit(String id, String nama, Date tglLahir, Date tglMasuk, String alamat, String gaji, String email, String jenisKelamin, String password, Role idRole) {
        Karyawan karyawan = new Karyawan(new BigDecimal(id), nama, tglLahir, tglMasuk, alamat, new BigInteger(gaji), email, jenisKelamin, password, idRole);
        return this.kdao.insertOrUpdate(karyawan);
    }

    private List<Karyawan> convertToListJob(List<Object> dataAwal) {
        List<Karyawan> dataKaryawan = new ArrayList<>();
        for (Object object : dataAwal) {
            Karyawan karyawan = (Karyawan)object;
            dataKaryawan.add(karyawan);
        }
        return dataKaryawan;
    }
    
    public List<Karyawan> getAllSort(String category,String sort) {
        return this.convertToListJob(this.kdao.getAllSort(category, sort));
    }

    public List<Karyawan> search(String category, String data) {
        return this.convertToListJob(this.kdao.search(category, data));
    }
    
    public Karyawan getById(String karyawanId){
        return this.kdao.getJobById(karyawanId);
    }
}
