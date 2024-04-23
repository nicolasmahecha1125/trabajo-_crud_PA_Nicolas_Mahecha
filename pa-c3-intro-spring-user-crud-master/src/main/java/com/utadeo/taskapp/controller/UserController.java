package com.utadeo.taskapp.controller;
import com.utadeo.taskapp.dto.ApiReponse;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ApiReponse store(@RequestBody User user){
        User userStore = this.userService.createUser(user);

        return new ApiReponse(
                HttpStatus.CREATED.value(),
                "usuario creado",
                userStore
        );
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }
    
   @GetMapping("/alluser")
   public List<User> getAllUsers(){
        return (List<User>) userService.getAllUsers();
   }

   @PutMapping("/{id}")
   public ApiReponse updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    User userUpdated = this.userService.updateUser(id, user);
    return new ApiReponse(
            HttpStatus.OK.value(),
            "usuario actualizado",
            userUpdated
    );
   }
   
   @DeleteMapping("/{id}") 
   public ApiReponse deleteUser(@PathVariable("id") Long id) {
     this.userService.deleteUser(id);
     return new ApiReponse(
             HttpStatus.NO_CONTENT.value(),
             "usuario eliminado",
             "eliminado"
     );
    
   }
    
    
}
