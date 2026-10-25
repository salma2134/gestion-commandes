
package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Client;

public interface ClientService {

    Client findById(int id);

    List<Client> findAll();

    void save(Client client);

    void delete(int id);

    void update(Client client);
}
