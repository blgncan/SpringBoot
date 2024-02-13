package com.aractakip.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(unique = true) //Dto NotNull olacak
   private String username;
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Json --> JAVA nesnesine
   private String password;
   private String name;
   private String surname;
   @Column(unique = true)
   private String phoneNumber;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
   private LocalDate birtDay;
   private String birtPlace;

   @OneToOne
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private UserRole userRole;

   @ManyToMany
   @JoinTable(
         name = "user_car",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "car_id")
   )
   @JsonIgnore
   private List<Car> carList;
}
