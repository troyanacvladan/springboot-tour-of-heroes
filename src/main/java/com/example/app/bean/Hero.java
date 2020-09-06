package com.example.app.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
