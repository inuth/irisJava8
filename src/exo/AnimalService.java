package exo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalService {
    // SINGLETON
    // => faire en sorte qu'il n'y ait qu'une seule instance d'une classe

    private static AnimalService instance;
    public static AnimalService getInstance(){
        if (instance == null)
            instance = new AnimalService();
        return instance;
    }

    private AnimalService(){}

    // trier les animaux par local
    public List<Animal> triParLocal(List<Animal> animaux){
       return animaux.stream()
               .sorted(Comparator.comparing(Animal::getNumLocal))
               .collect(Collectors.toList());
    }
    // récupérer tous les animaux du rez-de-chaussée

    public List<Animal> animauxRDC(List<Animal> animaux){
        return animaux.stream()
                .filter(a -> a.getNumLocal().startsWith("0"))
                .collect(Collectors.toList());
    }

    // récupérer les animaux ayant besoin du plus d'attention
    public List<Animal> animauxMaxAttention(List<Animal> animaux){
        // STEP 1 : récupérer le MAX
        Animal animalMax = animaux.stream()
                .max(Comparator.comparing(a -> a.getRepas().size() + a.getSoins().size()))
                .orElse(null);

        // solution meilleure car on a directement le max
        // pas besoin de le recalculer
        Integer max = animaux.stream()
                .mapToInt(a -> a.getRepas().size() + a.getSoins().size())
                .max().orElse(0);

        // STEP 2 : Filtrer par tous ceux qui ont ce MAX
        return animaux.stream()
                .filter(a -> a.getSoins().size() + a.getRepas().size() == max)
                .collect(Collectors.toList());

    }

    // récupérer la liste de soins de tous les animaux
    // -> le retour doit être : List<Integer>

    public List<Integer> totalSoins(List<Animal> animaux){
        List<Integer> soins = animaux.stream() // Stream<Animal>
                .flatMap(a -> a.getSoins().stream()) // Stream<Integer>
                .collect(Collectors.toList());

        return soins;
    }

    // récupérer une liste de String dont chaque String aura cette structure :
    //  ID_ANIMAL | NUM_LOCAL | NOMBRE_DE_SOINS | NOMBRE_DE_REPAS

    public List<String> AnimauxEnString(List<Animal> animaux){
        return animaux.stream()
                .map(a -> a.getId() + " | " + a.getNumLocal() + " | " + a.getSoins().size() + " " + a.getRepas().size())
                .collect(Collectors.toList());
    }

    // Récupérer l'animal dont on passe le local (String) en paramètre
    // si aucun animal : renvoyer null

    public Animal getAnimal(List<Animal> animaux, String local){
        return animaux.stream()
                .filter(a -> a.getNumLocal().equals(local))
                .findFirst()
                .orElse(null);
    }

    // récupérer la liste triée par ordre de priorité
    // la méthode prend un Integer en paramètre (représentant l'heure actuelle)

    public List<Animal> animauxPrio(Integer heure, List<Animal> animaux){
        List<AnimalPrio> animalPrios = new ArrayList<AnimalPrio>();

        List<AnimalPrio> finalAnimalPrios = animalPrios;
        animaux.stream()
                .forEach(a -> {
                    // transformer chaque soin en AnimalPrio
                    List<AnimalPrio> animalPriosSoin = a.getSoins().stream()
                            .map(s -> new AnimalPrio(s, a))
                            .collect(Collectors.toList());
                    // transformer chaque repas en AnimalPrio
                    List<AnimalPrio> animalPriosRepas = a.getRepas().stream()
                            .map(s -> new AnimalPrio(s, a))
                            .collect(Collectors.toList());

                    finalAnimalPrios.addAll(animalPriosSoin);
                    finalAnimalPrios.addAll(animalPriosRepas);
                });

        // toutes les heures précédentes vont être modifiées de façon
        // à ce qu'elle soit d'office après les dernières de la journée
        animalPrios.stream()
                .filter(a -> a.getHeure() < heure)
                .forEach(a -> a.setHeure(a.getHeure() + 24));


        animalPrios = animalPrios.stream()
                .sorted(Comparator.comparing(a -> a.getHeure()))
                .collect(Collectors.toList());

        animalPrios.stream()
            .filter(a -> a.getHeure() >= 24)
            .forEach(a -> a.setHeure(a.getHeure() - 24));

        return animalPrios.stream()
                .map(a -> a.getAnimal())
                .collect(Collectors.toList());


    }

}
