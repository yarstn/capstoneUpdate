package com.example.capstoneupdate.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID must not be null")
    private Integer id;
    @Column(columnDefinition =("varchar(20) not null unique") )
    @NotEmpty(message = "Username must not be empty")
    @Size(min = 5, message = "Username must be at least 5 characters long")
    private String username;
    @Column(columnDefinition =("varchar(200) not null ") )
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).+$", message = "Password must contain at least one character and one digit")
    private String password;
    @Column(columnDefinition =("varchar(30) not null unique") )
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid email address")
    private String email;
    @Column(columnDefinition = "varchar(8)")
    @Check(constraints = "category IN ('Admin', 'Customer')")
    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp = "^(Admin|Customer)$", message = "Role must be either 'Admin' or 'Customer'")
    private String role;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "Balance must not be null")
    @Min(value = 0, message = "Balance must be positive")
    private double balance;


}
