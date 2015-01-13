package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import lombok.Data;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Data
public class VehiclesResource {

    final VehicleContentManager vehicleMngr;

    @GET
    @UnitOfWork
    public List<Vehicle> listVehicles() {
        ResourceUtils.delay();
        return vehicleMngr.findAll();
    }

    @POST
    @UnitOfWork
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicleMngr.store(vehicle);
        return vehicle;
    }

}
