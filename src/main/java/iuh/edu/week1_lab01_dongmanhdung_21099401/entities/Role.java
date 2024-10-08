package iuh.edu.week1_lab01_dongmanhdung_21099401.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Size(max = 50)
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Size(max = 50)
    @NotNull
    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Size(max = 50)
    @Column(name = "description", length = 50)
    private String description;

    @NotNull
    @Column(name = "status", nullable = false)
    private Byte status;

    @OneToMany(mappedBy = "role")
    private Set<GrantAccess> grantAccesses = new LinkedHashSet<>();

    public Role(String roleId, String roleName, String description, Byte status, Set<GrantAccess> grantAccesses) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
        this.grantAccesses = grantAccesses;
    }

    public Role() {
    }

    public String getRoleId() {
        return roleId;
    }



    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Set<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(Set<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", grantAccesses=" + grantAccesses +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;

        return Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleId);
    }
}