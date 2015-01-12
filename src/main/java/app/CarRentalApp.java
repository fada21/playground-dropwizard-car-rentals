package app;

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
        // nothing to do yet
    }
}
