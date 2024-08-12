package com.example.capstoneupdate.Repository;

import com.example.capstoneupdate.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarchentRepositry extends JpaRepository<Merchant,Integer> {
}
