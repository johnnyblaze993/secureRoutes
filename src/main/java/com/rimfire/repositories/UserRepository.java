package com.rimfire.repositories;

import com.rimfire.entities.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES) // specify the dialect here
public interface UserRepository extends CrudRepository<User, UUID> {
    // your repository methods

    
}