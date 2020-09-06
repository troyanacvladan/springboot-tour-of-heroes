package com.example.app.controller;

import com.example.app.bean.Hero;
import com.example.app.service.HeroService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200") //enables cross-origin resource sharing only for this specific controller.
//In this example, we allow only http://localhost:4200 to send cross-origin requests.
@RequestMapping("api/heroes")
public class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping()
    public List<Hero> getHeros(){
        return heroService.getHeros();
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable Long id) throws NotFoundException {
        return heroService.getHero(id);
    }

    @PostMapping
    public Hero saveHero(@RequestBody Hero externalHero) throws NotFoundException {
        return heroService.saveOrUpdate(externalHero);
    }

    @PutMapping
    public Hero updateHero(@RequestBody Hero externalHero) throws NotFoundException {
        return heroService.saveOrUpdate(externalHero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable Long id) throws NotFoundException{
        heroService.deteleHero(id);
    }
}
