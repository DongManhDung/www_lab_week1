package iuh.edu.week1_lab01_dongmanhdung_21099401.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @EmbeddedId
    private GrantAccessId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @NotNull
    @Column(name = "is_grant", nullable = false)
    private Boolean isGrant = false;

    @Size(max = 250)
    @Column(name = "note", length = 250)
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(GrantAccessId id, Role role, Account account, Boolean isGrant, String note) {
        this.id = id;
        this.role = role;
        this.account = account;
        this.isGrant = isGrant;
        this.note = note;
    }

    public GrantAccessId getId() {
        return id;
    }

    public void setId(GrantAccessId id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(Boolean isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "id=" + id +
                ", role=" + role +
                ", account=" + account +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrantAccess that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}