package com.itboocamp.desafiospring.repository;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.util.JsonFileUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IRepository<Long, Product> {
    private static final String FILENAME = "arquivo.json";

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        return jsonFile.read();
    }

    @Override
    public Product insert(Product entity) {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        return jsonFile.append(entity);
    }

    @Override
    public void deleteById(Long id) {

    }
}
