package senned.restapp.service;

import senned.restapp.model.Client;
import java.util.List;

public interface ClientService {

    /**
     * Create new client
     */
    void create(Client client);

    /**
     * Return list of all clients
     */
    List<Client> readAll();

    /**
     * Return client with id
     */
    Client read(int id);

    /**
     Update client with id
     */
    boolean update(Client client, int id);

    /**
     Delete client with id
     */
    boolean delete(int id);
}
