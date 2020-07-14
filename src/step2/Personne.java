package step2;

import java.util.ArrayList;
import java.util.List;

public class Personne {
    private static int incId=1;
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private List<Habitation> habitations = new ArrayList<>();

    public Personne (String nom, String prenom, String adresse){
        this.id = incId++;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Integer getId() {
        return id;
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

    public List<Habitation> getHabitations() {
        return habitations;
    }

    public void setHabitations(List<Habitation> habitations) {
        this.habitations = habitations;
    }
}
