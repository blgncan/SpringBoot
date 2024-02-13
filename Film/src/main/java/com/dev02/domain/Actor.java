package com.dev02.domain;

import com.dev02.domain.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    @Setter(AccessLevel.NONE)
    private Long actorId;

    @NotBlank(message = "Aktör ismi Girmelisiniz")
    @Size(min = 2, max = 50, message = "Aktör İsmi : '${validatedValue}' en az {min} ve en fazla {max} karakter olmalıdır.")
    @Column(nullable = false,unique = true,length = 50)
    private String name;//

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")//opsiyonel
    private Gender gender;

    @ManyToMany(mappedBy = "actorSet", cascade = CascadeType.DETACH)//actorlSet in olacağı classtan setleme işlemi yapılacak
    @JsonIgnore//tostirng de tekrar obje üretmesin diye
    private Set<Film> filmSet = new HashSet<>();
}
