package com.example.capstoneupdate.Repository;

import com.example.capstoneupdate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User, Integer> {
}
