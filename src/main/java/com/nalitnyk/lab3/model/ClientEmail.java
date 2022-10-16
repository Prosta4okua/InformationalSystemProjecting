package com.nalitnyk.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "client_email")
public class ClientEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "client_id", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ЩОБИ НЕ ДОДАВАЛО ЗАЙВИЙ РЯДОК hibernateLazyInitializer ДО МОГО JSON RESPONSE
    private Client client;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}