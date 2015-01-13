package com.theappbusiness.health;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.setup.Environment;

/**
 *
 */
public class IsStartedHealthCheck extends HealthCheck {

    private final Environment environment;

    public IsStartedHealthCheck(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected Result check() throws Exception {
        if (environment!=null && environment.getApplicationContext().isStarted()) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Not started!");
        }
    }
}
