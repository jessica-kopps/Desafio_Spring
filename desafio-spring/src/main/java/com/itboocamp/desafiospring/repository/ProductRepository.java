package com.itboocamp.desafiospring.repository;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.util.JsonFileUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class ProductRepository implements IProductRepository<Long, Product> {
    private static final String FILENAME = "arquivo.json";

    @Override
    public Product findById(Long id) {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        Optional<Product> productOptional = this.findAll().stream()
                .filter(product -> product.getProductId().equals(id)).findFirst();
        return productOptional.orElse(null);
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
    public Product updateById(Long id, Product product) {
        JsonFileUtil<Product> jsonFile = new JsonFileUtil<Product>(FILENAME);
        List<Product> listUpdated = this.findAll().stream()
                .map(p -> {
                    if (p.getProductId().equals(product.getProductId())) return product;
                    return p;
                }).collect(Collectors.toList());
        jsonFile.update(listUpdated);
        return product;
    }

    @Override
    public Product findByNameAndCategory(String name, String category) {
        List<Product> products = findAll();

        return products.stream().filter(p -> {
            if (p.getName().equalsIgnoreCase(name) && p.getCategory().equalsIgnoreCase(category)) {
                return true;
            }
            return false;
        }).findFirst().orElse(null);
    }
}
