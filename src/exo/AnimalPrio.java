package exo;

public class AnimalPrio {
    private Integer heure;
    private Animal animal;

    public AnimalPrio(Integer heure, Animal animal) {
        this.heure = heure;
        this.animal = animal;
    }

    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
