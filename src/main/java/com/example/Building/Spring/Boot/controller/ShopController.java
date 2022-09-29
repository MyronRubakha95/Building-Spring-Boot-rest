package com.example.Building.Spring.Boot.controller;

import com.example.Building.Spring.Boot.dto.ShopDto;
import com.example.Building.Spring.Boot.entity.Shop;
import com.example.Building.Spring.Boot.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class ShopController {

    private ShopService shopService;


    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/dto")
    public ShopDto addDto(@RequestBody ShopDto shopDto) {
        return shopService.addShops(shopDto);
    }

    @SneakyThrows
    @PostMapping(value = "/shops/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop createShop(HttpServletRequest req, HttpServletResponse response) {
        BufferedReader reader = req.getReader();
        String shopJson = reader.lines().collect(Collectors.joining());

        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = objectMapper.readValue(shopJson, Shop.class);
        shopService.addShop(shop);
        return shop;
    }

    @DeleteMapping("/{id}")
    public Shop delete(@PathVariable String id) {
        return shopService.deleteShopId(id);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Shop getShop(HttpServletRequest req, HttpServletResponse response) {
        PrintWriter writer = response.getWriter();
        shopService.getShops().forEach(e -> writer.println(e.toString()));
        writer.flush();
        return null;
    }

    @GetMapping
    public Collection<Shop> getShops() {
        return shopService.getShops();
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop update(@RequestBody Shop shop, @PathVariable String id) {

        return shopService.update(shop, id);
    }

}