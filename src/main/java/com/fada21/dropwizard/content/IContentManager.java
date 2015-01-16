package com.fada21.dropwizard.content;

import java.util.List;

/**
 *
 */
public interface IContentManager<T> {

    boolean containsById(long id);

    boolean contains(T item);

    List<T> findAll();

    T findById(long id);

    void store(T item);

    void delete(long id);
}
