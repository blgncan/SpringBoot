package com.tpe.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Passenger {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please write passenger name ")
    private String passengerName;
    @NotBlank(message = "Please write passenger age ")
    private int passengerAge;
    @NotBlank(message = "Please write passenger gender ")
    private String gender;
    @NotBlank(message = "Please write passenger email address ")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Please write passenger phone number ")
    private String phone;
    @NotBlank
    @OneToMany(mappedBy = "passenger",cascade = CascadeType.REMOVE) //orders tarafında mapleyeceğiz
    private Set<Ticket> tickets=new HashSet<>();
}
