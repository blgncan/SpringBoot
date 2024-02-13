package com.aractakip.entity;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AccessLevel;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarRepair {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Setter(AccessLevel.NONE)
   private Long id;

   private Date repairDate;//zorunlu alan

   private int repairPrice;//zorunlu alan

   private String operations;

   @ManyToOne
   private Car car;


}
