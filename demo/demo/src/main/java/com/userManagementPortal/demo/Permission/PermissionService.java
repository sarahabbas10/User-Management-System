package com.userManagementPortal.demo.Permission;

import com.userManagementPortal.demo.Role.Role;
import com.userManagementPortal.demo.Role.RoleRepository;
import com.userManagementPortal.demo.User.User;
import com.userManagementPortal.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Autowired
    public PermissionService(PermissionRepository permissionRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List<Permission> getPermissions(){
         return permissionRepository.findAll();
    }

    public Permission getPermission(String permissionType){
        return permissionRepository.findByPermissionType(permissionType);
    }

    public Permission addPermission(Permission data,Long  idRole){
        if(idRole != null){
        Role role =roleRepository.findById(idRole).orElse(null);
        data.setRole(role);
        return permissionRepository.save(data);
        }
        else return null;
    }
    public Permission addPermissionToUser(Permission data,Long  idUser){
        if(idUser != null){
            User user =userRepository.findById(idUser).orElse(null);
            data.setUser(user);
            return permissionRepository.save(data);
        }
        else return null;
    }

}
