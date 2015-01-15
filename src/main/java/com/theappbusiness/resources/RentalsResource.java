package com.theappbusiness.resources;

import com.theappbusiness.content.RentalContentManager;
import com.theappbusiness.json.RentalStartJson;
import com.theappbusiness.model.Account;
import com.theappbusiness.model.Rental;
import io.dropwizard.jersey.PATCH;
import io.dropwizard.jersey.params.LongParam;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/rentals")
public class RentalsResource extends CrudResource<Rental, RentalContentManager> {

    public RentalsResource(RentalContentManager rentalContentManager) {
        super(rentalContentManager);
    }

    @GET
    @Path("/{id}/account")
    public Account getAccount(@PathParam("id") LongParam id) {
        long accountId = contentMngr.findById(id.get()).getAccountId();
        return contentMngr.getAccountContentManager().findById(accountId);
    }

    @GET
    @Path("/{id}/vehicle")
    public Account getVehicle(@PathParam("id") LongParam id) {
        long vehicleId = contentMngr.findById(id.get()).getVehicleId();
        return contentMngr.getAccountContentManager().findById(vehicleId);
    }

    @POST
    @Path("/start")
    public Rental startRental(RentalStartJson rentalStart) {
        validateRentalStart(rentalStart);
        Long id = contentMngr.getNextId();
        Rental.RentalBuilder builder = Rental.builder();
        Account account = contentMngr.getAccountContentManager().findByToken(rentalStart.getToken());
        Rental rental = builder.id(id).accountId(account.getId()).vehicleId(rentalStart.getVehicleId()).startHire(rentalStart.getStart()).build();
        contentMngr.store(rental);
        return rental;
    }

    private void validateRentalStart(RentalStartJson rentalStart) {
        if (rentalStart.getStart() > TimeUnit.MILLISECONDS.toSeconds(DateTime.now().getMillis())) {
            throw new WebApplicationException("rentalStart parameter must be in future", Response.Status.BAD_REQUEST);
        }

    }

    /**
     * @param end - timestamp for the end of rental
     */
    @PATCH
    @Path("{id}/end")
    public Rental startRental(@PathParam("id") LongParam id, long end) {
        Rental rental = contentMngr.findById(id.get());
        rental.setEndHire(end);
        return rental;
    }

    @GET
    @Path("/ongoing")
    public List<Rental> listOngoingRentals() {
        return contentMngr.findOngoing();
    }

    @GET
    @Path("/finished")
    public List<Rental> listFinishedRentals() {
        return contentMngr.findFinished();
    }

}
