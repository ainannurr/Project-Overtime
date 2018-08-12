/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JenisLemburDAO;
import entities.JenisLembur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AINAN
 */
public class JenisLemburController {
    
    private final JenisLemburDAO jldao;

    public JenisLemburController(JenisLemburDAO jldao) {
        this.jldao = jldao;
    }
    
    public boolean saveOrEdit(String id, String jenis) {
        JenisLembur jenisLembur = new JenisLembur(new Short(id), jenis);
        return this.jldao.insertOrUpdate(jenisLembur);
    }

    private List<JenisLembur> convertToListJob(List<Object> dataAwal) {
        List<JenisLembur> dataLembur = new ArrayList<>();
        for (Object object : dataAwal) {
            JenisLembur jl = (JenisLembur)object;
            dataLembur.add(jl);
        }
        return dataLembur;
    }
    
    public List<JenisLembur> getAll() {
        return this.convertToListJob(this.jldao.getAll());
    }

    public List<JenisLembur> search(String category, String data) {
        return this.convertToListJob(this.jldao.search(category, data));
    }
    
    public JenisLembur getById(String jenisId){
        return this.jldao.getJobById(jenisId);
    }
}
