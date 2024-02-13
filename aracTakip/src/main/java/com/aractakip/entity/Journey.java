package com.aractakip.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Journey {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy:HH-ss")
   private LocalDateTime journeyDate;//seyahat günü ve saati

   private String driver;//şöför

   private String distance;//mesafe

   @ManyToOne
   private Car car;//seyahat edilen araba
}
