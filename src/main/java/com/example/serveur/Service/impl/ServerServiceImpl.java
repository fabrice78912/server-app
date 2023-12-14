package com.example.serveur.Service.impl;

import com.example.serveur.Service.ServerService;
import com.example.serveur.entities.Server;
import com.example.serveur.enumeration.Status;
import com.example.serveur.repo.ServerRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.UUID;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server : {}" , server.getName());


/*        do {
            Long IdGenerated= Long.valueOf(UUID.randomUUID().toString());

        }while(serverRepo.findById(Long.valueOf(UUID.randomUUID().toString())).get() != null);
        server.setId(UUID.randomUUID().toString());*/
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    private String setServerImageUrl() {
        return  null;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepo.findAll(of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by id : {}", id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server  : {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by id : {}", id);
        serverRepo.deleteById(id);
        return TRUE;
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server : {}" , ipAddress);
        Server server=serverRepo.findByIpAddress(ipAddress);
        InetAddress address= InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Server update(Long id , Server serverUpade) throws IOException {
        Server server= this.get(id);
        server.setStatus(serverUpade.getStatus());
        server.setMemory(serverUpade.getMemory());
        server.setName(serverUpade.getName());
        server.setType(serverUpade.getType());
        server.setIpAddress(serverUpade.getIpAddress());
        //server.setImageUrl(serverUpade.getImageUrl());
        Server serverSaved = serverRepo.save(server);
        return serverSaved;
    }
}
