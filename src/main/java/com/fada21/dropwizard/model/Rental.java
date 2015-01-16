package com.fada21.dropwizard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rental implements HasId {

    long id;
    long accountId;
    long vehicleId;
    long startHire;
    long endHire;

}
