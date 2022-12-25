package com.userManagementPortal.demo.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.User.User;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String  roleType;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissionList=new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedRoles")
    private List <User> userList=new ArrayList<>();

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleType='" + roleType + '\'' +
                ", permissionList=" + permissionList +
                '}';
    }
}
