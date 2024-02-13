package com.tpe.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotBlank(message = "Please write guantity")
    private Integer guantity;//miktarı
    private Double totalPrice;
    @NotBlank(message = "Please write passenger")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Passenger passenger;
}
