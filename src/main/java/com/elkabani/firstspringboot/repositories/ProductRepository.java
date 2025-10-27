package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
    List<Product> findByCategoryId(Integer categoryId);
}
