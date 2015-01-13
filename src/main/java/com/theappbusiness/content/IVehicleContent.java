package com.theappbusiness.content;

import com.theappbusiness.model.Vehicle;

import java.util.List;

/**
 *
 */
public interface IVehicleContent {

    List<Vehicle> findAll();

    Vehicle findById(long id);
}
