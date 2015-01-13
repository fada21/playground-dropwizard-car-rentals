package com.theappbusiness.model;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

@Data
@Builder
@JsonSnakeCase
public class Vehicle {

    long id;
    @NotEmpty
    String registration;
    String type;
    BigDecimal pricePerHour;

}
