package ma.fstt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitService;

@ApplicationScoped
public class ProduitDAO implements ProduitService {

    @Override
    public List<Produit> findAll() {
        List<Produit> liste = new ArrayList<>();

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "SELECT * FROM produit"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produit p = new Produit();

                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setStock(rs.getInt("stock"));

                liste.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public Produit findById(int id) {
        Produit p = null;

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "SELECT * FROM produit WHERE id = ?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Produit();

                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public void save(Produit p) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO produit (nom, description, prix, stock) " +
                "VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, p.getNom());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrix());
            ps.setInt(4, p.getStock());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Produit p) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "UPDATE produit SET nom=?, description=?, prix=?, stock=? " +
                "WHERE id=?"
            );

            ps.setString(1, p.getNom());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrix());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "DELETE FROM produit WHERE id = ?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
