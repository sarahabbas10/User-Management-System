package com.userManagementPortal.demo.Role;

import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="roles")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/{roleType}")
    public Role getRole(@PathVariable String roleType){
        return roleService.getRole(roleType);
    }

    @PostMapping("/addRole")
    public String addRole(@RequestBody Role role){
        roleService.addRole(role);
        return  role.toString();
    }

    @GetMapping("/allPermissions")
    public List<Permission> getAllPermission(@RequestBody String roleType){
        return roleService.getAllPermission(roleType);
    }

    @DeleteMapping("{roleId}/deletePermission/{permissionId}")
    public String deletePermission(@PathVariable Long permissionId,
                                 @PathVariable Long roleId){
       return roleService.deletePermission(permissionId,roleId);
    }


}
