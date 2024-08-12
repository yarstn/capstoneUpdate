package com.example.capstoneupdate.Service;

import com.example.capstoneupdate.Model.User;
import com.example.capstoneupdate.Repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {
//    ArrayList<User> users = new ArrayList<>();
private final UserRepositry userRepositry;
    public List<User> getUsers() {
        return userRepositry.findAll();
    }

    public void addUser(User user) {
        userRepositry.save(user);
    }
    public boolean updateUser(Integer id,User user) {
  User search = userRepositry.getReferenceById(id);
  if(search != null) {
      search.setUsername(user.getUsername());
      search.setPassword(user.getPassword());
      search.setEmail(user.getEmail());
      search.setBalance(user.getBalance());
      search.setRole(user.getRole());
      userRepositry.save(search);
      return true;
  }
  return false;
    }

    public User getUser(Integer id) {
     User user = userRepositry.getReferenceById(id);
     if(user != null) {
         return user;
     }
     return null;
    }

    public boolean deleteUser(Integer id) {
    User user = userRepositry.getReferenceById(id);
    if(user != null) {
        userRepositry.delete(user);
        return true;
    }
    return false;
    }
}
