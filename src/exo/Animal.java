package exo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    private static int incId=1;
    private Integer id;
    private String numLocal;
    private List<Integer> repas = new ArrayList<>();
    private List<Integer> soins = new ArrayList<>();

    public Animal(String numLocal) {
        this.id = incId++;
        this.numLocal = numLocal;
    }

    public Animal ajoutRepas(Integer... repas){
        this.repas.addAll(Arrays.asList(repas));
        return this;
    }

    public Animal ajoutSoins(Integer... soins){
        this.soins.addAll(Arrays.asList(soins));
        return this;
    }

    public static int getIncId() {
        return incId;
    }

    public static void setIncId(int incId) {
        Animal.incId = incId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumLocal() {
        return numLocal;
    }

    public void setNumLocal(String numLocal) {
        this.numLocal = numLocal;
    }

    public List<Integer> getRepas() {
        return repas;
    }

    public void setRepas(List<Integer> repas) {
        this.repas = repas;
    }

    public List<Integer> getSoins() {
        return soins;
    }

    public void setSoins(List<Integer> soins) {
        this.soins = soins;
    }
}
