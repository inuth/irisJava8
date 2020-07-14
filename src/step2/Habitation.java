package step2;

import java.util.ArrayList;
import java.util.List;

public class Habitation {
    private static int incId=1;
    private Integer id;
    private String adresse;
    private List<Personne> habitants = new ArrayList<>();

    public Habitation(){
        this.id = incId++;
    }

    public Habitation(String adresse) {
        this.id = incId++;
        this.adresse = adresse;
    }

    public Integer getId(){
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Personne> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Personne> habitants) {
        this.habitants = habitants;
    }
}
