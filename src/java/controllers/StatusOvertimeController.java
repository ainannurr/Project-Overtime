/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.StatusOvertimeDAO;
import entities.StatusOvertime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author AINAN
 */
public class StatusOvertimeController {
    
    private final StatusOvertimeDAO overtimeDAO;

    public StatusOvertimeController(SessionFactory factory) {
        this.overtimeDAO = new StatusOvertimeDAO(factory);
    }
    
    /**
     * 
     * @param id
     * @param status
     * @return 
     */
    public boolean saveOrEdit(String id, String status) {
        StatusOvertime overtime = new StatusOvertime(new BigDecimal(id), status);
        return this.overtimeDAO.insertOrUpdate(overtime);
    }

    private List<StatusOvertime> convertToListJob(List<Object> dataAwal) {
        List<StatusOvertime> dataStatus = new ArrayList<>();
        for (Object object : dataAwal) {
            StatusOvertime overtime = (StatusOvertime)object;
            dataStatus.add(overtime);
        }
        return dataStatus;
    }
    
    public List<StatusOvertime> getAll() {
        return this.convertToListJob(this.overtimeDAO.getAll());
    }

    public List<StatusOvertime> search(String category, String data) {
        return this.convertToListJob(this.overtimeDAO.search(category, data));
    }
    
    public StatusOvertime getById(String statusId){
        return this.overtimeDAO.getJobById(statusId);
    }
}
