
package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.LigneDeCommande;

public interface LigneDeCommandeService {

    List<LigneDeCommande> findByCommande(int idCommande);

    void save(LigneDeCommande ligne);

    void delete(int id);
}
