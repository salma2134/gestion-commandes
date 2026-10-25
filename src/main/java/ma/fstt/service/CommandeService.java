
package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Commande;

public interface CommandeService {

    Commande findById(int id);

    List<Commande> findAll();

    int save(Commande commande);

    void delete(int id);
    void update(Commande commande);
}
