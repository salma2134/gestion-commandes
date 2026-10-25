package ma.fstt.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientService;

@ApplicationScoped
public class ClientDAO implements ClientService {

    @Override
    public List<Client> findAll() {
        List<Client> liste = new ArrayList<>();

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "SELECT * FROM client"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client c = new Client();

                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setEmail(rs.getString("email"));
                c.setTelephone(rs.getString("telephone"));
                c.setAdresse(rs.getString("adresse"));

                liste.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public Client findById(int id) {
        Client c = null;

        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "SELECT * FROM client WHERE id = ?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Client();

                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setEmail(rs.getString("email"));
                c.setTelephone(rs.getString("telephone"));
                c.setAdresse(rs.getString("adresse"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public void save(Client c) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO client (nom, prenom, email, telephone, adresse) " +
                "VALUES (?, ?, ?, ?, ?)"
            );

            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelephone());
            ps.setString(5, c.getAdresse());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client c) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "UPDATE client SET nom=?, prenom=?, email=?, telephone=?, adresse=? " +
                "WHERE id=?"
            );

            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelephone());
            ps.setString(5, c.getAdresse());
            ps.setInt(6, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection cnx = DBConnection.getConnection()) {

            PreparedStatement ps = cnx.prepareStatement(
                "DELETE FROM client WHERE id = ?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
