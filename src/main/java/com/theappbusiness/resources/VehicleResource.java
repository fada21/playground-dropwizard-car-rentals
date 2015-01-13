package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import lombok.Data;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicle/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Data
public class VehicleResource {

    final VehicleContentManager vehicleMngr;

    @GET
    @UnitOfWork
    public Vehicle getVehicle(@PathParam("id") LongParam id) {
        ResourceUtils.delay();
        return vehicleMngr.findById(id.get());
    }

    @PUT
    @UnitOfWork
    public Vehicle updateVehicle(@PathParam("id") LongParam id, Vehicle vehicle) {
        if (vehicleMngr.findById(id.get()) != null)
            vehicleMngr.store(vehicle);
        else
            new WebApplicationException(Response.Status.NO_CONTENT);
        return vehicle;
    }

    @DELETE
    @UnitOfWork
    public Response deleteVehicle(@PathParam("id") LongParam id) {
        if (vehicleMngr.findById(id.get()) != null) {
            vehicleMngr.delete(id.get());
            return Response.status(Response.Status.OK).build();
        } else
            throw new WebApplicationException(Response.Status.NO_CONTENT);
    }
}


}
