package com.example.capstoneupdate.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID cannot be empty")
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Column(columnDefinition =("varchar(20) not null unique") )
    @Size(min = 2, max = 20, message = "Name size must be between 3 - 20")
    private String name;
}
