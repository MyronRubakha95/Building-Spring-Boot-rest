package com.example.Building.Spring.Boot.service;


import com.example.Building.Spring.Boot.dto.ShopDto;
import com.example.Building.Spring.Boot.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ShopService {

    private final HashMap<String, Shop> db = new HashMap<>();

    public ShopDto addShops(ShopDto shopDto) {
        Shop shop = convertToEntity(shopDto);
        return shopDto;
    }

    private Shop convertToEntity(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setNameShop(shopDto.getNameShop());
        shop.setStreet(shopDto.getStreet());
        shop.setCity(shopDto.getCity());
        shop.setId(shopDto.getId());
        shop.setWebsite(shopDto.isWebsite());
        return shop;

    }

    public Shop addShop(Shop shop) {
        db.put(shop.getId(), shop);
        return shop;
    }

    public Shop deleteShopId(String id) {
        return db.remove(id);
    }

    public Shop getShop() {
        Shop shop1 = db.get(id);
        return shop1;
    }

    public Collection<Shop> getShops() {
        return db.values();
    }

    public Shop update(Shop shop, String id) {

        Shop shop2 = db.get(id);

        shop2.setCity(shop.getCity());
        shop2.setStreet(shop.getStreet());
        shop2.setNameShop(shop.getNameShop());
        shop2.setWorkers(shop.getWorkers());
        shop2.setWebsite(shop.isWebsite());

        return shop2;

    }
}
