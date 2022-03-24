package com.itboocamp.desafiospring.repository;

import com.itboocamp.desafiospring.entity.Product;

import java.util.List;

public class ProductRepository implements IRepository<Long, Product> {
    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product insert(Product entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
