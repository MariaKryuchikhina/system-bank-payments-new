package com.spring.rest.systembankpayments.services;

import com.spring.rest.systembankpayments.entity.Client;

import java.util.List;

public interface CrudService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void deleteById(ID id);

}