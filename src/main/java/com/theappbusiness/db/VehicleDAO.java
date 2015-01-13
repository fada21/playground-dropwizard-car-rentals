package com.theappbusiness.db;

import com.theappbusiness.json.VehicleJson;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class VehicleDAO {

    public List<VehicleJson> findAll() {
        VehicleJson.VehicleJsonBuilder builder = VehicleJson.builder();
        VehicleJson vehicle1 = builder.id(1).registration("LON1").type("car").pricePerHour(new BigDecimal(10)).build();
        VehicleJson vehicle2 = builder.id(2).registration("LON2").type("car").pricePerHour(new BigDecimal(12)).build();
        VehicleJson vehicle3 = builder.id(3).registration("LON3").type("car").pricePerHour(new BigDecimal(20)).build();
        return Arrays.asList(vehicle1, vehicle2, vehicle3);
    }
}
