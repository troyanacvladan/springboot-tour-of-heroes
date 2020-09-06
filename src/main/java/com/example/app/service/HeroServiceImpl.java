package com.example.app.service;

import com.example.app.bean.Hero;
import com.example.app.repository.HeroRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Override
    public List<Hero> getHeros() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Hero getHero(Long id) throws NotFoundException {
        Optional<Hero> hero = heroRepository.findById(id);
        if(!hero.isPresent()){
            throw new NotFoundException("Not found element with id:"+id.toString());
        }
        return hero.get();
    }

    @Override
    public Hero saveOrUpdate(Hero externalHero) {
        Optional<Hero> heroFromDB = heroRepository.findById(externalHero.getId());
        if(heroFromDB.isPresent()){ //update
            Hero hero = heroFromDB.get();
            BeanUtils.copyProperties(externalHero, hero);
            heroRepository.save(hero);
            return hero;
        }else { //save
            Hero newHero = new Hero();
            BeanUtils.copyProperties(externalHero, newHero);
            heroRepository.save(newHero);
            return newHero;
        }
    }

    @Override
    public void deteleHero(Long id) throws NotFoundException {
        Optional<Hero> hero = heroRepository.findById(id);
        if(!hero.isPresent()){
            throw new NotFoundException("Not found element with id:"+id.toString());
        }
        heroRepository.delete(hero.get());
    }
}
