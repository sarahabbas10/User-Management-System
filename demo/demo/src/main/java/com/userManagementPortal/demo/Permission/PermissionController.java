package com.userManagementPortal.demo.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="permissions")
@CrossOrigin("*")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/{permissionType}")
    public Permission getPermission(@PathVariable String permissionType) {
       return permissionService.getPermission(permissionType);
    }

    @PostMapping("/addPermissionToRole")
    public Permission addPermission(@RequestBody RoleForm form){
        return permissionService.addPermission(form.getPermission(),form.getRoleId());
    }


    @PostMapping("/addPermissionToUSer")
    public Permission addPermissionToUser(@RequestBody UserForm form){
        return permissionService.addPermissionToUser(form.getPermission(),form.getUserId());
    }
}
class UserForm{
    private Permission permission;
    private String userId;
    public Long getUserId() {return Long.parseLong(userId);}
    public Permission getPermission(){return permission;}
}

class  RoleForm{
    private Permission permission;
    private String roleId;
    public Long getRoleId() {return Long.parseLong(roleId);}
    public Permission getPermission(){return permission;}
}
