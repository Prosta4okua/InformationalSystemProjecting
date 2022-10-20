package com.nalitnyk.repository;

import com.nalitnyk.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository  extends JpaRepository<ExchangeRate, Long> {
}
