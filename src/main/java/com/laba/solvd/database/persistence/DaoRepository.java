package com.laba.solvd.database.persistence;

import java.util.List;

public interface DaoRepository<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    T read(int id);
    List<T> getAll();
}
