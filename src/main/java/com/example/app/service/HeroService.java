package com.example.app.service;

import com.example.app.bean.Hero;
import javassist.NotFoundException;

import java.util.List;

public interface HeroService {

    List<Hero> getHeros();
    Hero getHero(Long id) throws NotFoundException;
    Hero saveOrUpdate(Hero externalHero);
    void deteleHero(Long id) throws NotFoundException;
}
