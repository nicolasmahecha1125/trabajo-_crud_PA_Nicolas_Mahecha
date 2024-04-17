package com.utadeo.taskapp.controller;
import org.springframework.web.bind.annotation.RestController;

import com.utadeo.taskapp.model.User;
import com.utadeo.taskapp.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {

    private IUserService userService;

    UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public User store(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return this.userService.getById(id);
    }
    
   @GetMapping("/alluser")
   public List<User> getAllUsers(){
        return (List<User>) userService.getAllUsers();
   }

   @PutMapping("/{id}")
   public User updateUser(@PathVariable Long id, @RequestBody User user) {
    user.setId(id); 
    return this.userService.updateUser(id, user); 
   }
   
   @DeleteMapping("/{id}") 
   public void deleteUser(@PathVariable Long id) {
       this.userService.deleteUser(id); 
   }
    
    
}
