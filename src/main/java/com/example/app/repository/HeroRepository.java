package com.example.app.repository;

import com.example.app.bean.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {
}
