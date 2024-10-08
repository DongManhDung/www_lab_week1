package iuh.edu.week1_lab01_dongmanhdung_21099401.services;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account;
import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.GrantAccess;
import iuh.edu.week1_lab01_dongmanhdung_21099401.repositories.AccountRepository;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;
    public AccountServices(){
        accountRepository = new AccountRepository();
    }

    public Account getUsernameAndPassword(String username, String password){
        return accountRepository.getUsernameAndPassword(username, password);
    }

    public Account getAccountById(String id){
        return accountRepository.getAccount(id);
    }

    public boolean deleteAccount(String id){
        return accountRepository.deleteAccount(id);
    }

    public boolean updateAccount(Account account){
        return accountRepository.updateAccount(account);
    }

    public boolean createAccount(Account account, GrantAccess grantAccess){
        return accountRepository.AddAccount(account, grantAccess);
    }


}
