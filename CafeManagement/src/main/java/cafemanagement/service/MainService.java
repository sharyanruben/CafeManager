package cafemanagement.service;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
public interface MainService<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T getById(int id);

    List<T> getAll();
}
