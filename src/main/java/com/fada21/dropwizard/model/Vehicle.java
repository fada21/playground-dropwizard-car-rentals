package com.fada21.dropwizard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle implements HasId {

    long id;
    @NotEmpty
    String registration;
    String type;
    double pricePerHour; // TODO should have used double but was not working out of the box

}
