package com.springrest.Second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@RepositoryRestResource()
public interface ProductServices extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByPrice(double price);
    // List<Product> findByPriceBetween(double price1,double price2);
}
