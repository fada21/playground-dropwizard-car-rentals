package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;
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
