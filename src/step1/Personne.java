package step1;

public class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    // si vous avez une lettre
    // si je commence par 0
    // est-ce que je vais faire des opérations mathématiques dessus ?
    private String num;

    public Personne(String nom, String prenom, String adresse, String num) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
