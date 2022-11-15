package com.nalitnyk.Lab4.repositories;

import com.nalitnyk.Lab4.models.Exchange;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<Exchange, Integer> {
}
