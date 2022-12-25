package com.userManagementPortal.demo.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleType(String RoleType);

}
