package com.autoexpenses.repository;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, I extends Serializable> extends Repository<T, I> {

    void delete(T deleted);

    List<T> findAll();

    Optional<T> findOne(Long id);

    T save(T persisted);
}
