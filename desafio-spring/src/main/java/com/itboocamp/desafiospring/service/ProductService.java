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

    public List<Product> listProducts(ProductFilter filters, String priceSort, String nameSort) {
        List<Product> listProducts = filter(filters, productRepository.findAll());
        if (priceSort != null) {
            this.priceSort(listProducts, priceSort);
        }
        if (nameSort != null) {
            this.nameSort(listProducts, nameSort);
        }
        return listProducts;
    }

    private void priceSort(List<Product> listProducts, String priceSort) {
        if (priceSort.equals("asc")) {
            listProducts.sort((a, b) -> a.getPrice().compareTo(b.getPrice()));
        } else if (priceSort.equals("dsc")) {
            listProducts.sort((b, a) -> a.getPrice().compareTo(b.getPrice()));
        }
    }

    private void nameSort(List<Product> listProducts, String nameSort) {
        if (nameSort.equals("asc")) {
            listProducts.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        } else if (nameSort.equals("dsc")) {
            listProducts.sort((b, a) -> a.getName().compareToIgnoreCase(b.getName()));
        }
    }


    private List<Product> filter(ProductFilter filter, List<Product> list) {
        List<Product> listFiltered = list;

        listFiltered = filter.filterProductId(listFiltered);
        listFiltered = filter.filterName(listFiltered);
        listFiltered = filter.filterCategory(listFiltered);
        listFiltered = filter.filterBrand(listFiltered);
        listFiltered = filter.filterPrice(listFiltered);
        listFiltered = filter.filterQuantity(listFiltered);
        listFiltered = filter.filterFreeShipping(listFiltered);
        listFiltered = filter.filterPrestige(listFiltered);
        
        return listFiltered;
    }
}
