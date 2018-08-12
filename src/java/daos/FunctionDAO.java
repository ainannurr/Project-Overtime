/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AINAN
 */
public class FunctionDAO implements InterfaceDAO{
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean insertOrUpdate(Object object) {
        boolean flag = false;
        try {
            this.session = this.factory.openSession(); //membuka session
            this.transaction = this.session.beginTransaction(); //memulai transaksi
            this.session.saveOrUpdate(object); //melakukan save
            this.transaction.commit(); //mengeksekusi session
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            if(this.transaction != null){
                this.transaction.rollback(); //mengambil data terakhir dari database
            }
        } finally {
            this.session.close(); //menutup session
        }
        return flag;
    }

    @Override
    public List<Object> get(String query) {
        List<Object> datas = new ArrayList<>();
        try {
            this.session = this.factory.openSession(); //membuka session
            this.transaction = this.session.beginTransaction(); //memulai transaksi
            datas = this.session.createQuery(query).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(this.transaction != null){
                this.transaction.rollback(); //mengambil data terakhir dari database
            }
        } finally {
            this.session.close(); //menutup session
        }
        return datas;
    }

    @Override
    public Object getById(String query) {
        Object data = new Object();
        try {
            this.session = this.factory.openSession(); //membuka session
            this.transaction = this.session.beginTransaction(); //memulai transaksi
            data = this.session.createQuery(query).uniqueResult();
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(this.transaction != null){
                this.transaction.rollback(); //mengambil data terakhir dari database
            }
        } finally {
            this.session.close(); //menutup session
        }
        return data;
    }

    @Override
    public String getAutoId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
