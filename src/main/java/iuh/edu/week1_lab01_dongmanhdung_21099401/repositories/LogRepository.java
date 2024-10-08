package iuh.edu.week1_lab01_dongmanhdung_21099401.repositories;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class LogRepository {
    private EntityManagerFactory emf;
    public LogRepository() {
        emf = Persistence.createEntityManagerFactory("AccountMySql");
    }

    public boolean addLog(Log log) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Log getLog(String accountID) {
        try (EntityManager em = emf.createEntityManager()) {
            Query query = em.createQuery("SELECT l FROM Log l WHERE l.accountId = :accountID order by l.loginTime desc limit 1");
            query.setParameter("accountID", accountID);
            return (Log) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateLog(Log log) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(log);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
