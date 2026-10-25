package ma.fstt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeService;

@ApplicationScoped
public class CommandeDAO implements CommandeService {

    private static final String SELECT =
        "SELECT c.id, c.date_commande, c.statut, " +
        "cl.id AS id_client, cl.nom, cl.prenom " +
        "FROM commande c JOIN client cl ON c.id_client = cl.id";

    @Override
    public List<Commande> findAll() {
        List<Commande> liste = new ArrayList<>();

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                liste.add(lire(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public Commande findById(int id) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                SELECT + " WHERE c.id = ?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return lire(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int save(Commande c) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO commande (date_commande, statut, id_client) " +
                "VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setDate(1, Date.valueOf(c.getDateCommande()));
            ps.setString(2, c.getStatut());
            ps.setInt(3, c.getClient().getId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void update(Commande c) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "UPDATE commande SET date_commande=?, statut=?, id_client=? " +
                "WHERE id=?"
            );

            ps.setDate(1, Date.valueOf(c.getDateCommande()));
            ps.setString(2, c.getStatut());
            ps.setInt(3, c.getClient().getId());
            ps.setInt(4, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "DELETE FROM ligne_commande WHERE id_commande=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            ps = cnx.prepareStatement(
                "DELETE FROM commande WHERE id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Commande lire(ResultSet rs) throws SQLException {

        Client client = new Client();
        client.setId(rs.getInt("id_client"));
        client.setNom(rs.getString("nom"));
        client.setPrenom(rs.getString("prenom"));

        Commande c = new Commande();
        c.setId(rs.getInt("id"));
        c.setDateCommande(
            rs.getDate("date_commande").toLocalDate()
        );
        c.setStatut(rs.getString("statut"));
        c.setClient(client);

        return c;
    }
}