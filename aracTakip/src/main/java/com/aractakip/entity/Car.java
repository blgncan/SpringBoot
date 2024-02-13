package com.aractakip.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true)
   private String plate;

   private String brand;
   private String model;

   @ManyToMany(mappedBy ="carList", fetch = FetchType.EAGER)
   private List<User> user;

   @OneToMany(mappedBy = "car",cascade = CascadeType.REMOVE)
   private List<Journey> journey;

   @OneToMany(mappedBy = "car",cascade = CascadeType.REMOVE)
   private List<CarFuel> carFuels;

   @OneToMany(mappedBy = "car",cascade = CascadeType.REMOVE)
   private List<CarRepair> carRepairList;
}
