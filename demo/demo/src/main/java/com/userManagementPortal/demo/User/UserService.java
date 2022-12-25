package com.userManagementPortal.demo.User;

import com.userManagementPortal.demo.Permission.Permission;
import com.userManagementPortal.demo.Role.Role;
import com.userManagementPortal.demo.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

     @Autowired
     public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Role> roleList=new ArrayList<>();



    public List<User> getUsers(){
     return userRepository.findAll();
 }

    public User getUser(String username){
     return userRepository.findByUsername(username);
 }

    public void updateUser(String id,User data){
     Long userId= Long.parseLong(id);
     User user=userRepository.findById(userId).orElse(null);
             user.setUsername(data.getUsername());
             user.setPassword(data.getPassword());
             userRepository.save(user);
     }


     public User login(User data) {
     User user = userRepository.findByUsername(data.getUsername());
     if (user.getPassword().equals(data.getPassword())) {
         return user;
     }
     return null;
     }

     public User addUser(User user,String roleType){
       if(roleType.equals("superAdmin"))
      return userRepository.save(user);
       else
           return null;
     }

     public List<Role> getAllRoles(String userName){
      User user=  userRepository.findByUsername(userName);
      return user.getAssignedRoles();
     }

    public User assignRoleToUser(Long userId, Long roleId) {

         User user=userRepository.findById(userId).get();
         Role role=roleRepository.findById(roleId).get();
        roleList= user.getAssignedRoles();
        roleList.add(role);
        user.setAssignedRoles(roleList);
        return userRepository.save(user);
    }
    public boolean checkPermission(Long userId){
        User user=userRepository.findById(userId).get();
        if(user.getPermissionList()!=null)
            return true;

        else
            return false;
    }
    public List<Permission> getAllPermissionInUser(Long userId){
        User user=userRepository.findById(userId).get();

        if(user.getPermissionList()!=null)
            return user.getPermissionList();

        else
            return null;
    }





}
