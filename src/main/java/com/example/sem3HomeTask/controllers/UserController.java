package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public void userAddFromBody(@RequestBody User user) {

        service.processRegistration(user);
    }

    @GetMapping("/{name}/{age}/{email}")
    public void userAddFromParam(@PathVariable("name") String name,
                                 @PathVariable("age") int age,
                                 @PathVariable("email") String email) {
        User user = service.getUserService().createUser(name, age, email);
        service.processRegistration(user);

    }
}



