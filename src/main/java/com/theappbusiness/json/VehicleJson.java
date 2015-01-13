package com.theappbusiness.json;

import lombok.Data;
import lombok.experimental.Builder;

import java.math.BigDecimal;

@Data
@Builder
public class VehicleJson {

    long id;
    String registration;
    String type;
    BigDecimal pricePerHour;
}
