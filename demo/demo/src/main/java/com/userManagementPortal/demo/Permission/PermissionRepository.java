package com.userManagementPortal.demo.Permission;


import com.userManagementPortal.demo.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    public Permission findByPermissionType(String permissionType);
}
