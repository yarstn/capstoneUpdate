package com.example.capstoneupdate.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID cannot be empty")
    private Integer id;
    @Column(columnDefinition =("int not null unique") )
    @NotNull(message = "productId cannot be empty")
    private Integer productId;
    @NotNull(message = "merchantId cannot be empty")
    @Column(columnDefinition =("int not null unique") )
    private Integer merchantId;
    @Column(columnDefinition =("int not null ") )
    @Min(value = 10, message = " stock have to be more than 10 at start)")
    private int stock;
}
