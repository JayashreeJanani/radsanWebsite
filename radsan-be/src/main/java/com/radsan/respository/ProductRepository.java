package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
