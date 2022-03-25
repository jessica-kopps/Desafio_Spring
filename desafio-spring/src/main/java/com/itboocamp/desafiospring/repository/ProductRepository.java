package com.itboocamp.desafiospring.repository;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.util.JsonFileUtil;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IRepository<Long, Product> {
    private static final String FILENAME = "arquivo.json";

    @Override
    public Product findById(Long id) {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        Optional<Product> productOptional = jsonFile.read().stream()
                .filter(product -> product.getProductId() == id)
                .findFirst();
        return productOptional.orElse(null);
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
