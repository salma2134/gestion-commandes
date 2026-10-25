package ma.fstt.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {

    private int id;
    private LocalDate dateCommande;
    private String statut;
    private Client client;
    private List<LigneDeCommande> lignes = new ArrayList<>();

    public Commande() {
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public int getId() {
        return id;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public List<LigneDeCommande> getLignes() {
        return lignes;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStatut() {
        return statut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLignes(List<LigneDeCommande> lignes) {
        this.lignes = lignes;
    }

    public double getTotal() {
        double somme = 0;

        for (LigneDeCommande l : lignes) {
            somme += l.getTotal();
        }

        return somme;
    }
}