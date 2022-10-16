package com.nalitnyk.lab3.repository;

import com.nalitnyk.lab3.model.ClientEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<ClientEmail, Long> {
}
