package com.fada21.dropwizard.resources;

import com.fada21.dropwizard.content.VehicleContentManager;
import com.fada21.dropwizard.model.Vehicle;
import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Path;

@Path(VehiclesResource.PATH)
@Api(value = VehiclesResource.PATH, description = "Operations on vehicles")
public class VehiclesResource extends CrudResource<Vehicle, VehicleContentManager> {

    public static final String PATH = "/vehicles";

    public VehiclesResource(VehicleContentManager vehicleContentManager) {
        super(vehicleContentManager);
    }

}
