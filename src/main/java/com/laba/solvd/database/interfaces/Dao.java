package com.laba.solvd.database.interfaces;

import java.util.List;

public interface Dao<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    T read(int id);
    List<T> getAll();
}
