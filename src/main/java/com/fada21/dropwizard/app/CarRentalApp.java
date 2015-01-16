package com.fada21.dropwizard.app;

import com.fada21.dropwizard.content.AccountContentManager;
import com.fada21.dropwizard.content.RentalContentManager;
import com.fada21.dropwizard.content.VehicleContentManager;
import com.fada21.dropwizard.health.IsStartedHealthCheck;
import com.fada21.dropwizard.resources.AccountsResource;
import com.fada21.dropwizard.resources.RentalsResource;
import com.fada21.dropwizard.resources.VehiclesResource;
import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;
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

        final RentalContentManager rentalContentManager = new RentalContentManager(accountMngr, vehicleMngr);
        RentalsResource rentalsResource = new RentalsResource(rentalContentManager);
        environment.jersey().register(rentalsResource);

        initSwagger(environment);
    }

    private void initSwagger(Environment environment) {
        environment.jersey().register(new ApiListingResourceJSON());
        environment.jersey().register(new ApiDeclarationProvider());
        environment.jersey().register(new ResourceListingProvider());

        // Swagger Scanner, which finds all the resources for @Api Annotations
        ScannerFactory.setScanner(new DefaultJaxrsScanner());

        // Add the reader, which scans the resources and extracts the resource information
        ClassReaders.setReader(new DefaultJaxrsApiReader());

        SwaggerConfig config = ConfigFactory.config();
        config.setApiVersion("0.0.1");
    }

}
