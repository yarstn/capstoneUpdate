package com.example.capstoneupdate.Repository;

import com.example.capstoneupdate.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer> {
}
