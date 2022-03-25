package com.itboocamp.desafiospring.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.itboocamp.desafiospring.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonFileUtil<T> {
    private String filename;

    public JsonFileUtil(String filename){
        this.filename = filename;
    }

    private void createFile(){
        FileWriter file = null;
        try {
            file = new FileWriter(this.filename);
            file.write("[]");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> read(Class<T> elementClass){
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> tList = new ArrayList<>();

        try {
            File file = new File(filename);
            //tList = objectMapper.readValue(file, new TypeReference<List<T>>(){});
            CollectionType listType =
                    objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
            return objectMapper.readValue(file, listType);


        } catch (FileNotFoundException e){
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tList;
    }

    public T append(T t, Class<T> elementClass){
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> tList = this.read(elementClass);
        tList.add(t);

        try {
            objectMapper.writeValue(new File(filename), tList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<T> update(List<T> newList) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(filename), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }
}
