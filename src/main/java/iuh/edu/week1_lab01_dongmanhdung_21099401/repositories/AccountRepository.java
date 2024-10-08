package iuh.edu.week1_lab01_dongmanhdung_21099401.repositories;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account;
import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.GrantAccess;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@Stateless
public class AccountRepository {
    private EntityManagerFactory emf;
    public AccountRepository(){
        emf = Persistence.createEntityManagerFactory("AccountMySql");
    }

    public Account getAccount(String id){
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Account.class, id);  // Find account by id
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Account getUsernameAndPassword(String username, String password){
        try (EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT a FROM Account a WHERE a.accountId = :username AND a.password = :password", Account.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean AddAccount(Account account, GrantAccess grantAccess) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(account);
            em.merge(grantAccess);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAccount(Account account) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(String id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Account account = em.find(Account.class, id);
            em.remove(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
