package com.example.capstoneupdate.Repository;

import com.example.capstoneupdate.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarchentStockRepositry extends JpaRepository<MerchantStock, Integer> {
}
