package iuh.edu.week1_lab01_dongmanhdung_21099401.repositories;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account;
import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private EntityManagerFactory emf;
    public RoleRepository(){
        emf = Persistence.createEntityManagerFactory("AccountMySql");
    }

    public List<Account> getAccountByRoleId(String roleId){
        List<Account> accountList = new ArrayList<Account>();
        try (EntityManager em = emf.createEntityManager()){
            Query q = em.createQuery("SELECT acc from Account acc inner join GrantAccess g on acc.accountId = g.account.accountId where g.role.roleId = :roleId");
            q.setParameter("roleId", roleId);
            accountList = (List<Account>) q.getResultList();
            return accountList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }

    public Role getRole(String name){
        return emf.createEntityManager().find(Role.class, name);
    }

    public Role getRoleOfAccount(String accountId){
        Role role = null;
        try (EntityManager em = emf.createEntityManager()){
            Query q = em.createQuery("SELECT r from Role r join GrantAccess g on r.roleId = g.role.roleId where g.account.accountId = :accountId");
            q.setParameter("accountId", accountId);
            role = (Role) q.getSingleResult();
            return role;
        } catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }
}
