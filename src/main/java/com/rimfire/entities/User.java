package com.rimfire.entities;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@MappedEntity
public record User (
    @Id @NotNull UUID id,
    @NotNull String username,
    @NotNull String password
) {

}