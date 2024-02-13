package com.dev02.domain;
import com.dev02.domain.enums.CategoryType;
import com.dev02.domain.enums.LanguageName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "film_id")
    private Long filmID;

    @NotBlank(message = "you must enter film name")
    @Column(length = 50,unique = true,nullable = false)
    @Size(min = 2,max = 50,message = "First name '${validatedValue}' must be between {min} and {max}")

    private String movieName;
    private Integer relaseYear;
    private Integer length;
    private  double imdbScore;

    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "MM/dd/yyy",timezone = "Turkey")
    @Setter(AccessLevel.NONE)
    private LocalDateTime lastUpdate=LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(length = 30,nullable = false)
    private CategoryType categoryType;

    @Column(name = "Language_name")
    @Enumerated(EnumType.STRING)
    private LanguageName languageName;

    @ManyToMany//lazy de kalsın istersek actorler gelsin
    @JoinTable(name = "film_actor",//3.oluşacak tablonun adı
            joinColumns = {@JoinColumn(name = "film_id")},//tablo adı
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})//bağlantılı tablo
    private  Set<Actor> actorSet= new HashSet<>();

}
