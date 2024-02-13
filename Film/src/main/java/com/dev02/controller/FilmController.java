package com.dev02.controller;

import com.dev02.domain.Film;
import com.dev02.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Film film){
        filmService.saveMovie(film);

        return new ResponseEntity<>("Filminiz Başarıyla Kayıt Edilmiştir", HttpStatus.CREATED);//201
    }

    //tüm filmeleri dto da gösterme  id ve date olmayacak
    // film ismine göre film  getirme(tüm isim ve ismin bir kaç harfi ile)
    //film id si ile film silme.
    //film id si ile film güncelleme
    //actor ismine göre filmleri getirme

}