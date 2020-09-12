package be.ordina.controller;

import be.ordina.model.Hero;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//Only required when not using EnableWebSecurity
//@CrossOrigin(origins ="*", maxAge=3600)
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Hero> someHeroes = List.of(
            new Hero(1, "Ken"),
            new Hero(2, "Yannick"),
            new Hero(3, "Pieter"),
            new Hero(4, "New Hero"));

    @GetMapping
    public List<Hero> heroes() {
        return someHeroes;
    }

    @GetMapping("/{id}")
    public Hero hero(@PathVariable("id") String id) {
        return someHeroes.stream()
                .filter(h -> Integer.toString(h.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }
}

