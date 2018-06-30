/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernateUtil.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ale
 */
public class DAO {

    public void salvar(Object objeto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(objeto);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public void delete(Object objeto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    public void update (Object objeto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(objeto);
        transaction.commit();
        session.flush();
        session.close();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ObservableList consultar(Class classe){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(classe);
        List results = crit.list();
        session.flush();//LiberaMemoria
        session.close();
        //Convertendo List em ObservableList
        ObservableList lista = FXCollections.observableArrayList();
        for (int i = 0; i < results.size();i++){
            lista.add(results.get(i));
        }
        return lista;
    }
}
