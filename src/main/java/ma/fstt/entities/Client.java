
package ma.fstt.entities;

public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;

    public Client() {
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;  }

    public void setPrenom(String prenom) {
        this.prenom = prenom;}
    

    public String getEmail() {
        return email;}
    

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;}
    

    public String getPrenom() {
        return prenom;           }
    

      public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

       public String getTelephone() {
        return telephone;
    }

       public void setEmail(String email) {
        this.email = email;
    }

       public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
