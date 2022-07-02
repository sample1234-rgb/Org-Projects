package com.springrest.Third.repository;

import com.springrest.Third.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel="Products",path = "Products")
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByPrice(double price);
    // List<Product> findByPriceBetween(double price1,double price2);
}
