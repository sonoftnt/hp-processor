package com.tnt.hp.Controller;


import com.tnt.hp.Entity.User;
import com.tnt.hp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;
/*
    * sample JSON Object
    * { "emailId" : "test@gmail.com",
    *   "username" : "test",
    *   "password" : "pw123",
    *   "firstName" : "first name",
    *   "lastName" : "last name",
    *   "age" : 19
    * }
    *
    * */
    @PostMapping("/signUp")
    public String signUp(@RequestBody User newUser){
      return  userService.addUser(newUser);
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody Map<String,String> userDetais){
        String emailId = userDetais.get("emailId");
        String password = userDetais.get("password");
        System.out.println(emailId);
        System.out.println(password);
        return userService.signIn(emailId,password);
    }

}
