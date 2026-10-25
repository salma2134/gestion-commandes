package ma.fstt.entities;

public class Produit {

    private int id;
    private String nom;
    private String description;
    private double prix;
    private int stock;

    public Produit() {
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}