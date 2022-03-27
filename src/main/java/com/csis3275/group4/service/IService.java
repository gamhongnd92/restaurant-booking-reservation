package com.csis3275.group4.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IService<T> {
	void add(T obj);
    void delete(String Id);
    void update(String Id, T obj);
    List<T> getAll();
    Optional<T> getById(UUID Id);
}
