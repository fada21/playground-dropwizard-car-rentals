package com.theappbusiness.model;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSnakeCase
public class Account implements HasId {

    long id;
    @NotEmpty
    String name;
    boolean isAdmin;
    String token;
}
