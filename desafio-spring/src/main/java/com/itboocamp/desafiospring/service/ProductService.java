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
        List<Product> listFiltered = list;

        if (filter.getProductId() != null) {
            listFiltered = list.stream().filter(product -> {
                return filter.getProductId() == product.getProductId();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getName() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return product.getName().toUpperCase().contains(filter.getName().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getCategory() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return product.getCategory().toUpperCase().contains(filter.getCategory().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getBrand() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return product.getBrand().toUpperCase().contains(filter.getBrand().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getPrice() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getPrice() == product.getPrice();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getQuantity() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getQuantity() == product.getQuantity();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getFreeShipping() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getFreeShipping() == product.getFreeShipping();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getPrestige() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getPrestige() == product.getPrestige();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        return listFiltered;
    }
}
