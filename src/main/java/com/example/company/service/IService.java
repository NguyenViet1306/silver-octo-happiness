package com.example.company.service;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

     T save(T t);

     void delete(Long id);

}
