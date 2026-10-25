package ma.fstt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.LigneDeCommande;
import ma.fstt.entities.Produit;
import ma.fstt.service.LigneDeCommandeService;

@ApplicationScoped
public class LigneDeCommandeDAO implements LigneDeCommandeService {

    @Override
    public List<LigneDeCommande> findByCommande(int idCommande) {
        List<LigneDeCommande> liste = new ArrayList<>();

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "SELECT l.id, l.quantite, l.prix_unitaire, p.nom " +
                "FROM ligne_commande l JOIN produit p " +
                "ON l.id_produit = p.id " +
                "WHERE l.id_commande = ?"
            );

            ps.setInt(1, idCommande);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Produit p = new Produit();
                p.setNom(rs.getString("nom"));

                LigneDeCommande ligne = new LigneDeCommande();
                ligne.setId(rs.getInt("id"));
                ligne.setIdCommande(idCommande);
                ligne.setQuantite(rs.getInt("quantite"));
                ligne.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                ligne.setProduit(p);

                liste.add(ligne);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public void save(LigneDeCommande ligne) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO ligne_commande " +
                "(id_commande, id_produit, quantite, prix_unitaire) " +
                "VALUES (?, ?, ?, ?)"
            );

            ps.setInt(1, ligne.getIdCommande());
            ps.setInt(2, ligne.getProduit().getId());
            ps.setInt(3, ligne.getQuantite());
            ps.setDouble(4, ligne.getPrixUnitaire());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "DELETE FROM ligne_commande WHERE id = ?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
