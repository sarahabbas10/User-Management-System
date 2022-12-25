package com.userManagementPortal.demo.User;

import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.Role.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String  username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Permission> permissionList=new ArrayList<>();

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_id")  ,
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> assignedRoles = new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getAssignedRoles() {
        return assignedRoles;
    }

    public void setAssignedRoles(List<Role> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissionList=" + permissionList +
                ", assignedRoles=" + assignedRoles +
                '}';
    }
}
