package com.theappbusiness.app;

import com.theappbusiness.content.AccountContentManager;
import com.theappbusiness.content.VehicleContentManager;
import com.theappbusiness.health.IsStartedHealthCheck;
import com.theappbusiness.model.Account;
import com.theappbusiness.resources.AccountsResource;
import com.theappbusiness.resources.VehiclesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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

        final VehicleContentManager vehicleMngr = new VehicleContentManager();
        final VehiclesResource vehiclesResource = new VehiclesResource(vehicleMngr);
        environment.jersey().register(vehiclesResource);

        final AccountContentManager accountMngr = new AccountContentManager();
        AccountsResource accountsResource = new AccountsResource(accountMngr);
        environment.jersey().register(accountsResource);
    }
}
