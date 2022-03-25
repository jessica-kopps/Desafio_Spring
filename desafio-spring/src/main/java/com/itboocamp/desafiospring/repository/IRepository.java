package com.itboocamp.desafiospring.repository;

import java.util.List;

public interface IRepository  <U extends  Number, T>{
    T findById(U id);
    List<T> findAll();
    T insert(T entity);
    void deleteById(U id);
    T findByName(String name);
    T findByCategory(String category);
    T updateById(U id, T entity);
}
