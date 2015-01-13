package com.theappbusiness.resources;

import com.theappbusiness.db.VehicleDAO;
import io.dropwizard.hibernate.UnitOfWork;
import com.theappbusiness.json.VehicleJson;
import lombok.Data;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 */
@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Data
public class VehiclesResource {

    final VehicleDAO vehicleDAO;

    @GET
    @UnitOfWork
    public List<VehicleJson> listVehicles() {

        return vehicleDAO.findAll(); // TODO ended here
    }
}
