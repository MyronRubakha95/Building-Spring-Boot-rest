package com.example.Building.Spring.Boot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ShopDto  {

    private String id;
    private String city;
    private String street;
    private String nameShop;
    private boolean website;
}
