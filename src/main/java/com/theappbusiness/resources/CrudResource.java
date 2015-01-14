package com.theappbusiness.resources;

import com.theappbusiness.content.IContentManager;
import com.theappbusiness.model.HasId;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class CrudResource<T extends HasId, CM extends IContentManager<T>> {

    final CM contentMngr;

    public CrudResource(CM cm) {
        contentMngr = cm;
    }

    @GET
    public List<T> listItems() {
        return contentMngr.findAll();
    }

    @GET
    @Path("{id}")
    public T getItem(@PathParam("id") LongParam id) {
        return contentMngr.findById(id.get());
    }

    @POST
    public T createItem(T item) {
        if (!contentMngr.contains(item)) {
            contentMngr.store(item);
        } else {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }
        return item;
    }

    @PUT
    @Path("{id}")
    public T updateItem(@PathParam("id") LongParam id, T item) {
        if (contentMngr.containsById(id.get())) {
            contentMngr.store(item);
            return item;
        } else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    @Path("{id}")
    public Response deleteItem(@PathParam("id") LongParam id) {
        if (contentMngr.containsById(id.get())) {
            contentMngr.delete(id.get());
            return Response.status(Response.Status.OK).build();
        } else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
