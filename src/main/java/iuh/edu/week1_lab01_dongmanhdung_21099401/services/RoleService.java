package iuh.edu.week1_lab01_dongmanhdung_21099401.services;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Account;
import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Role;
import iuh.edu.week1_lab01_dongmanhdung_21099401.repositories.RoleRepository;

import java.util.List;

public class RoleService {
    public RoleRepository roleRepository;

    public RoleService(){
        roleRepository = new RoleRepository();
    }

    public List<Account> getAccountByRoleId(String role){
        return roleRepository.getAccountByRoleId(role);
    }

    public Role getRoleOfAccount(String accountId){
        return roleRepository.getRoleOfAccount(accountId);
    }

    public Role getRole(String name){
        return roleRepository.getRole(name);
    }
}
