package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.dto.request.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import com.itboocamp.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductRequestDTO request) {
        return productRepository.insert(new EntityMapper().mapDTO(request));
    }

    public Product findByNameAndCategory(String name, String category) {
        return productRepository.findByNameAndCategory(name, category);
    }

    public List<Product> listProducts(ProductFilter filters, Integer sort) {
        List<Product> listProducts = filter(filters, productRepository.findAll());
        if (sort != null) {
            this.sort(listProducts, sort);
        }

        return listProducts;
    }

    private void sort(List<Product> listProducts, Integer sort) {
        switch (sort) {
            case 0:
                listProducts.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
                break;
            case 1:
                listProducts.sort((b, a) -> a.getName().compareToIgnoreCase(b.getName()));
                break;
            case 2:
                listProducts.sort((b, a) -> a.getPrice().compareTo(b.getPrice()));
                break;
            case 3:
                listProducts.sort((a, b) -> a.getPrice().compareTo(b.getPrice()));
                break;
        }
    }


    private List<Product> filter(ProductFilter filter, List<Product> list) {
        filter.setProductsList(list);
        filter.filterProductId()
                .filterName()
                .filterCategory()
                .filterBrand()
                .filterPrice()
                .filterQuantity()
                .filterFreeShipping()
                .filterPrestige();

        return filter.getProductsList();
    }
}
