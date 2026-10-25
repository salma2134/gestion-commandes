package ma.fstt.entities;

public class LigneDeCommande {

    private int id;
    private int quantite;
    private double prixUnitaire;
    private Produit produit;
    private int idCommande;

    public LigneDeCommande() {
    }

    public int getQuantite() {
        return quantite;
    }

    public int getId() {
        return id;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public double getTotal() {
        return quantite * prixUnitaire;
    }
}