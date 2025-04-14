package com.example.demo_jpa;

import com.example.demo_jpa.entities.Product;
import com.example.demo_jpa.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {
    @Autowired

    private IProduct iProduct;
    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }
    @Override
    public void run(String... args) {
        iProduct.save(new Product(null,"iPhone",5000,66));
        iProduct.save(new Product(null ,"computer",4500,55));
        iProduct.save(new Product( null,"phone",2500,45));
        iProduct.save(new Product(null,"TV",6500,55));
        iProduct.save(new Product(null,"TV2",5500,24));
        iProduct.save(new Product(null,"TV3",7500,10));
        iProduct.deleteById(3L);
//        iProduct.findById()
//List<Product> productList=iProduct.search("T",200);
List<Product> productList = iProduct.findAll();
        productList.forEach(p->{
            System.out.println(p.getName());
            System.out.println(p.getPrice());
            System.out.println(p.getQuantity());
            System.out.println("=====================");

        });





    }
}
