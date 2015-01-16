package com.fada21.dropwizard.content;

import com.fada21.dropwizard.model.HasId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class BaseMockedContentManager<T extends HasId> implements IContentManager<T> {


    protected abstract Map<Long, T> getMockMap();

    @Override
    public boolean containsById(long id) {
        return getMockMap().containsKey(id);
    }

    @Override
    public boolean contains(T item) {
        return getMockMap().containsValue(item);
    }

    @Override
    public T findById(long id) {
        return getMockMap().get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(getMockMap().values());
    }

    @Override
    public void store(T item) {
        getMockMap().put(item.getId(), item);
    }

    @Override
    public void delete(long id) {
        getMockMap().remove(id);
    }

}
