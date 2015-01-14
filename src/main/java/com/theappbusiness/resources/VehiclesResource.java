package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiclesResource extends CrudResource<Vehicle, VehicleContentManager> {

    public VehiclesResource(VehicleContentManager vehicleContentManager) {
        super(vehicleContentManager);
    }

    @GET
    public List<Vehicle> listVehicles() {
        return super.listItems();
    }

    @GET
    public Vehicle getVehicle(@PathParam("id") LongParam id) {
        return super.getItem(id.get());
    }

    @POST
    @Path("{id}")
    public Vehicle createVehicle(Vehicle item) {
        return super.createItem(item);
    }

    @PUT
    @Path("{id}")
    public Vehicle updateVehicle(@PathParam("id") LongParam id, Vehicle item) {
        return super.updateItem(id.get(), item);
    }

    @DELETE
    @Path("{id}")
    public Response deleteVehicle(@PathParam("id") LongParam id) {
        return super.deleteItem(id.get());
    }
}
