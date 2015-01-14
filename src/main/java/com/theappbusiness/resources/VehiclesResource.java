package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vehicles")
public class VehiclesResource extends CrudResource<Vehicle, VehicleContentManager> {

    public VehiclesResource(VehicleContentManager vehicleContentManager) {
        super(vehicleContentManager);
    }

}
