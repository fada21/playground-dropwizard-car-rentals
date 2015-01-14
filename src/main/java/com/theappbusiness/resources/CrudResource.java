package com.theappbusiness.resources;

import com.theappbusiness.content.IContentManager;
import com.theappbusiness.model.HasId;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public abstract class CrudResource<T extends HasId, CM extends IContentManager<T>> {

    final CM contentMngr;

    protected CrudResource(CM cm) {
        contentMngr = cm;
    }

    protected List<T> listItems() {
        return contentMngr.findAll();
    }

    protected T getItem(long id) {
        return contentMngr.findById(id);
    }

    protected T createItem(T item) {
        if (!contentMngr.contains(item)) {
            contentMngr.store(item);
        } else {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }
        return item;
    }

    protected T updateItem(long id, T item) {
        if (contentMngr.containsById(id)) {
            contentMngr.store(item);
            return item;
        } else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    protected Response deleteItem(long id) {
        if (contentMngr.containsById(id)) {
            contentMngr.delete(id);
            return Response.status(Response.Status.OK).build();
        } else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
