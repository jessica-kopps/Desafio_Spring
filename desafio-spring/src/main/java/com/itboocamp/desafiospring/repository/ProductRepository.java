package com.itboocamp.desafiospring.repository;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.util.JsonFileUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
        return jsonFile.read(Product.class);
    }

    @Override
    public Product insert(Product entity) {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        return jsonFile.append(entity, Product.class);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product findByName(String name) {
        List<Product> products = findAll();
        return  products.stream().filter(p -> p.getName().toLowerCase(Locale.ROOT)
                .equalsIgnoreCase(name.toLowerCase(Locale.ROOT))).findFirst().orElse(null);
    }

    @Override
    public Product findByCategory(String category) {
        List<Product> products = findAll();
        return  products.stream().filter(p -> p.getCategory().toLowerCase(Locale.ROOT)
                .equalsIgnoreCase(category.toLowerCase(Locale.ROOT))).findFirst().orElse(null);
    }
}
