package com.nalitnyk.Lab4.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "exchange_rate")
public class Exchange {
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

    @Override
    public String toString() {
        return "\nExchange # "+ id + ". Exchange rate: " + rateToUah + ". Updated at" + updatedAt;
    }
}