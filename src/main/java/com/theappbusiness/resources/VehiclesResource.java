package com.theappbusiness.resources;

import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.model.Vehicle;

import javax.ws.rs.Path;

@Path("/vehicles")
public class VehiclesResource extends CrudResource<Vehicle, VehicleContentManager> {

    public VehiclesResource(VehicleContentManager vehicleContentManager) {
        super(vehicleContentManager);
    }

}
