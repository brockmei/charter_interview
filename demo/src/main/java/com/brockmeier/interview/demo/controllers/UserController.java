package com.brockmeier.interview.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brockmeier.interview.demo.services.UserService;

import types.User;
import types.UserServiceResponse;





//Write a password validation rest service configurable via IoC (using a dependency injection 
//      engine of your choice). The service is meant to check a text string for 
//      compliance with any number of password validation rules. The rules currently known are:
//• Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
//• Must be between 5 and 12 characters in length.
//• Must not contain any sequence of characters immediately followed by the same sequence.
//Implement a UI that would allow a password to be sent to the backend service.



//Authentication is not required for the service or UI.  
//If you can either send us a zipped project or a github link with the implementation, 
//along with documentation as to how to execute the project, I’d like to see how you handle it.

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
   @Autowired UserService userService;

   @PostMapping("/user/update") 
   private ResponseEntity<UserServiceResponse> updateUser(@RequestBody User user) {
      UserServiceResponse response = new UserServiceResponse();
      ArrayList<String> issues = null;
      issues = userService.validatePassword(user.password());
      if (issues.size() > 0) {
         response.setResults(issues);
         response.setMessage("Errors were found during validation");
         return ResponseEntity.badRequest().body(response);
      } else {
         response.setMessage("Validation Succeeded");
         return ResponseEntity.ok().body(response);
      }        
   }
   
   @GetMapping(value = "/user")
   public String getUsers() { return "hello World"; }
   
}
