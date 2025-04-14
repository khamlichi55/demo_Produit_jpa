package com.example.demo_jpa.repository;

import com.example.demo_jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProduct  extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String kw);
    @Query("select p from Product p where p.name like %:mc% and p.price > :p ")
    List<Product> search(@Param("mc") String mc, @Param("p") double p);
    void Update (long id, String name, int price);
}
