package com.userManagementPortal.demo.Permission;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userManagementPortal.demo.Role.Role;
import com.userManagementPortal.demo.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String  permissionType;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private Role role;
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private User user;


    public Permission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionType='" + permissionType + '\'' +
                ", role=" + role +
                '}';
    }
}
