package com.ram.myretro.persistance;

import java.util.Optional;

public interface SimpleRepository<D,ID> {
    D save(D d);

    Optional<D> findById(ID id);

    Iterable<D> findAll();

    void deleteById(ID id);
}
