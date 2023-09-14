package com.example.serveur.repo;

import com.example.serveur.entities.Server;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repo for Server entity
 */
public interface ServerRepo extends JpaRepository<Server, Long> {

    Server findByIpAddress(String ipAddress);
    Server findByName(String name);
}
