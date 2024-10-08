package iuh.edu.week1_lab01_dongmanhdung_21099401.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrantAccessId implements Serializable {
    private static final long serialVersionUID = -530311471188361455L;
    @Size(max = 50)
    @NotNull
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Size(max = 50)
    @NotNull
    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    public GrantAccessId(String roleId, String accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }

    public GrantAccessId() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantAccessId entity = (GrantAccessId) o;
        return Objects.equals(this.accountId, entity.accountId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, roleId);
    }

}