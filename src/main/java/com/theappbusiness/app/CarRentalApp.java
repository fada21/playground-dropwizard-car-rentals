package com.theappbusiness.app;

import com.theappbusiness.db.VehicleDAO;
import com.theappbusiness.health.IsStartedHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.theappbusiness.resources.VehiclesResource;

/**
 *
 */
public class CarRentalApp extends Application<CarRentalConfiguration> {

    public static void main(String[] args) throws Exception {
        new CarRentalApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<CarRentalConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CarRentalConfiguration carRentalConfiguration, Environment environment) throws Exception {
        environment.healthChecks().register("isStarted", new IsStartedHealthCheck(environment));

        final VehicleDAO vehicleDAO = new VehicleDAO();
        final VehiclesResource vehiclesResource = new VehiclesResource(vehicleDAO);
        environment.jersey().register(vehiclesResource);
    }
}
