package com.aractakip.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;
import java.time.LocalDateTime;
import com.aractakip.entity.enums.FuelType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarFuel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Setter(AccessLevel.NONE)
   private Long id;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy:HH-ss")
   private LocalDateTime fuelTime;//ZORUNLU ALAN

   private Integer fuelLiter;//zorunlu alan

   private Integer fuelPrice;//zorunlu alan

   private FuelType fuelType;//zorunlu alan

   @ManyToOne
   @JsonIgnore
   private Car car;

}
