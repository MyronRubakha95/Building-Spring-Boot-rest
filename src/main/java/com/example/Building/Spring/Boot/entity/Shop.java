package com.example.Building.Spring.Boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String city;
    private String street;
    private String nameShop;
    private String workers;
    private boolean website;

    public Shop() {

    }
}
