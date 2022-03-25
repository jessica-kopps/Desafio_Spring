package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import com.itboocamp.desafiospring.repository.ProductProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
public class ProductService {
    @Autowired
    private ProductProductRepository productRepository;

    public Product create(ProductRequestDTO request) {
        return productRepository.insert(new EntityMapper().mapDTO(request));
    }

    public Product findByNameAndCategory(String name, String category) {
        return productRepository.findByNameAndCategory(name, category);
    }

    public List<Product> listProducts(ProductFilter filters, String priceSort, String nameSort) {
        List<Product> listProducts = filter(filters, productRepository.findAll());
        if(priceSort!=null){
            this.priceSort(listProducts, priceSort);
        }
        if(nameSort!=null) {
            this.nameSort(listProducts, nameSort);
        }
        return listProducts;
    }

    private void priceSort(List<Product> listProducts, String priceSort) {
        if(priceSort.equals("asc")){
             listProducts.sort((a,b)->a.getPrice().compareTo(b.getPrice()));
        }else if(priceSort.equals("dsc")){
             listProducts.sort((b,a)->a.getPrice().compareTo(b.getPrice()));
        }
    }

    private void nameSort(List<Product> listProducts, String nameSort){
        if(nameSort.equals("asc")){
            listProducts.sort((a,b)->a.getName().compareToIgnoreCase(b.getName()));
        } else if(nameSort.equals("dsc")){
            listProducts.sort((b,a)->a.getName().compareToIgnoreCase(b.getName()));
        }
    }


    private List<Product> filter (ProductFilter filter, List<Product> list) {
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
