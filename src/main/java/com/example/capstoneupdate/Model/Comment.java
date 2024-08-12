//
//// Comment.java
//package com.example.capstoneupdate.Model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@Data
//@AllArgsConstructor
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column(columnDefinition =("int not null unique") )
//    @NotNull(message = "userID cannot be empty")
//    private Integer userId;
//    @Column(columnDefinition =("int not null unique") )
//    @NotNull(message = "productID cannot be empty")
//    private Integer productId;
//    @Column(columnDefinition = "varchar(250)")
//    @NotNull(message = "rating cannot be empty")
//    private String comment;
//
//}
//
