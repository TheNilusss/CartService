package com.study.cartService.repository;

import com.study.cartService.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {

    public Cart findByCID(String CID);

}