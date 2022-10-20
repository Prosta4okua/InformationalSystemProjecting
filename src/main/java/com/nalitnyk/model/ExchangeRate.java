package com.nalitnyk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {
    @Id
    @Column(name = "currency_name", nullable = false, length = 50)
    private String id;

    @Column(name = "\"rate_to_uah\"", nullable = false)
    private Double rateToUah;

    @Column(name = "\"updated_at\"", nullable = false)
    private Instant updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRateToUah() {
        return rateToUah;
    }

    public void setRateToUah(Double rateToUah) {
        this.rateToUah = rateToUah;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}