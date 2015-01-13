package com.theappbusiness.content;

import com.theappbusiness.model.Vehicle;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class VehicleContentManager implements IVehicleContent {

    private final static Map<Long, Vehicle> vehiclesMap = new ConcurrentHashMap<>();

    static {
        Vehicle.VehicleBuilder builder = Vehicle.builder();
        String type = "car";
        vehiclesMap.put(1l, builder.id(1).registration("LL01ABC").type(type).pricePerHour(new BigDecimal(10)).build());
        vehiclesMap.put(2l, builder.id(2).registration("LL02ABC").type(type).pricePerHour(new BigDecimal(12)).build());
        vehiclesMap.put(3l, builder.id(3).registration("LL03ABC").type(type).pricePerHour(new BigDecimal(15)).build());
        vehiclesMap.put(4l, builder.id(4).registration("LL04ABC").type(type).pricePerHour(new BigDecimal(15)).build());
        vehiclesMap.put(5l, builder.id(5).registration("LL05ABC").type(type).pricePerHour(new BigDecimal(15)).build());
        vehiclesMap.put(6l, builder.id(6).registration("LL06ABC").type(type).pricePerHour(new BigDecimal(20)).build());
        vehiclesMap.put(7l, builder.id(7).registration("SN00PD0G").type(type).pricePerHour(new BigDecimal(100)).build());
    }

    public Vehicle findById(long id) {
        return vehiclesMap.get(id);
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(vehiclesMap.values());
    }

    public void store(Vehicle v) {
        vehiclesMap.put(v.getId(), v);
    }

    public void delete(Long id) {
        vehiclesMap.remove(id);
    }
}
