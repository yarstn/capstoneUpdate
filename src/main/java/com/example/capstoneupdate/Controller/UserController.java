package com.example.capstoneupdate.Controller;

import com.example.capstoneupdate.Model.User;
import com.example.capstoneupdate.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
//DONE
    @GetMapping("/get")
public ResponseEntity getAllUsers(){
        if(userService.getUsers().isEmpty()){
            return ResponseEntity.status(400).body("No users found");
        }
        return ResponseEntity.ok(userService.getUsers());
    }
//DONE
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body("User added");
    }
    //DONE
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user){
        boolean success = userService.updateUser(id, user);
        if(success){
            return ResponseEntity.status(201).body("User updated");
        }
        return ResponseEntity.status(400).body("User not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("User deleted");
        }
        return ResponseEntity.status(400).body("User not found");
    }
}
