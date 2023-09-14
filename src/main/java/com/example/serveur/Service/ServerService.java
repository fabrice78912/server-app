package com.example.serveur.Service;

import com.example.serveur.entities.Server;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {

    Server create(Server server );
    Collection<Server> list(int limit);
    Server get (Long id);
    Server update(Server server);
    Boolean delete(Long id);
    Server ping (String ipAddress) throws IOException;
}
