package com.theappbusiness.content;

import com.theappbusiness.model.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class VehicleContentManager extends BaseMockedContentManager<Vehicle> {

    private final Map<Long, Vehicle> vehiclesMap = new ConcurrentHashMap<>();

    public VehicleContentManager() {
        Vehicle.VehicleBuilder builder = Vehicle.builder();
        String type = "car";
        vehiclesMap.put(1l, builder.id(1).registration("LL01ABC").type(type).pricePerHour(10).build());
        vehiclesMap.put(2l, builder.id(2).registration("LL02ABC").type(type).pricePerHour(12).build());
        vehiclesMap.put(3l, builder.id(3).registration("LL03ABC").type(type).pricePerHour(15).build());
        vehiclesMap.put(4l, builder.id(4).registration("LL04ABC").type(type).pricePerHour(15).build());
        vehiclesMap.put(5l, builder.id(5).registration("LL05ABC").type(type).pricePerHour(15).build());
        vehiclesMap.put(6l, builder.id(6).registration("LL06ABC").type(type).pricePerHour(20).build());
        vehiclesMap.put(7l, builder.id(7).registration("SN00PD0G").type(type).pricePerHour(100).build());
    }

    @Override
    protected Map<Long, Vehicle> getMockMap() {
        return vehiclesMap;
    }

}
