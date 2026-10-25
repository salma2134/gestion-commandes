
package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Produit;

public interface ProduitService {

    Produit findById(int id);

    List<Produit> findAll();

    void save(Produit produit);

    void delete(int id);

    void update(Produit produit);
}
