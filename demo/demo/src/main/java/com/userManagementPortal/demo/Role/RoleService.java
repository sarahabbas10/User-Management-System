package com.userManagementPortal.demo.Role;


import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.Permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private  RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;


    @Autowired
    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public List<Role> getRoles (){
        return roleRepository.findAll();
    }

    public Role getRole(String roleType){
      return roleRepository.findByRoleType(roleType);
    }

    public Role addRole(Role role){
       return roleRepository.save(role);
    }


    public List<Permission> getAllPermission(String roleType){
        Role role=roleRepository.findByRoleType(roleType);
        return role.getPermissionList();
    }

    public String deletePermission(Long permissionId,Long roleId){
        Role role=roleRepository.findById(roleId).get();
        List <Permission> permissionList=role.getPermissionList();
        Permission permission=permissionRepository.findById(permissionId).get();
       if (permissionList.contains(permission)){
            permissionRepository.deleteById(permissionId);
            return "Delete it";
        }
       else{
       return "not delete it";
       }
    }



}
