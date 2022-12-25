package com.userManagementPortal.demo.User;

import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUsers(){
       return userService.getUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){

        return userService.getUser(username);
    }

    @GetMapping("/roles/{username}")
    public List<Role> getAllRoles(@PathVariable String username){
        return userService.getAllRoles(username);
    }

    @GetMapping("/checkPermission/{userId}")
    public boolean checkPermission(@PathVariable Long userId){
        return userService.checkPermission(userId);
    }

    @GetMapping("/allPermissions/{userId}")
    public List<Permission> getAllPermissionInUser(@PathVariable Long userId){
        return userService.getAllPermissionInUser(userId);
    }

    @PostMapping("addUser/{roleType}")
    public String addUser (@RequestBody User user,@PathVariable String roleType){
         userService.addUser(user,roleType);
         return user.toString();
    }


    @PostMapping("/login")
    public User login (@RequestBody User user){
        return userService.login(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User data){
        userService.updateUser(id, data);
       User user= userService.getUser(data.getUsername());
        return user.toString();
    }

    @PutMapping("/{userId}/role/{roleId}")
    public User assignRoleToUser(
            @PathVariable Long userId,
            @PathVariable Long roleId
    ){
        return userService.assignRoleToUser(userId,roleId);
    }


}
