package com.groupeisi.tp.dao;

import com.groupeisi.tp.config.HibernateUtil;
import com.groupeisi.tp.entities.Compte;
import com.groupeisi.tp.entities.Droit;
import com.groupeisi.tp.interfaces.IDroit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DroitDAO extends RepositoryDAO<Droit> implements IDroit {

    public List<Droit> getAllDroit() {

        Transaction transaction = null;
        List < Droit > listOfDroit = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfDroit = session.createQuery("from Droit").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDroit;
    }
}
