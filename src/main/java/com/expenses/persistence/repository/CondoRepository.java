package com.expenses.persistence.repository;


import com.expenses.persistence.entities.CondoEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CondoRepository extends Repository<CondoEntity, Long> {

    void delete(CondoEntity deleted);

    List<CondoEntity> findAll();

    Optional<CondoEntity> findById(Long id);

    CondoEntity save(CondoEntity persisted);
}
