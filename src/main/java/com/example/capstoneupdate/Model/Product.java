package com.example.capstoneupdate.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID cannot be empty")
    private Integer id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 20, message = "Name size must be between 3 - 20")
    @Column(columnDefinition =("varchar(20) not null unique") )
    private String name;
    @NotNull(message = "Price cannot be empty")
@Positive
    @Column(columnDefinition = "int not null")
    private double price;
    @NotNull(message = "Category ID cannot be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer categoryId;
//    private List<Comment> comments = new ArrayList<>();
//    public void addComment(Comment comment) {
//        this.comments.add(comment);
//    }




    // Copy constructor
    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
    }



}
