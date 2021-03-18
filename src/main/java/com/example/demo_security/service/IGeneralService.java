package com.example.demo_security.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    E findById(Long id);

    void remove(Long id);

    E update(E e);

    E add(E e);
}
