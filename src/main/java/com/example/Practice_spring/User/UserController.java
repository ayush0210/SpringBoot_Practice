package com.example.Practice_spring.User;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fetch-users")
public class UserController {
    private final UserService controller;


    public UserController(UserService controller) {
        this.controller = controller;
    }

    @GetMapping
    public User[] getUsers(){
        return controller.fetchUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return controller.getUserById(id);
    }

    @PostMapping("/Post-users")
    public String importUsers()  {
        try {
            controller.fetchandaddusers();
            return "Users added successfully";
        } catch (Exception e) {
            return  "Error importing" + e.getMessage();
        }

    }
}
