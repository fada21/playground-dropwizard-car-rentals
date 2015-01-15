package com.theappbusiness.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalStartJson {

    long start;
    String token;
    long vehicleId;

}
