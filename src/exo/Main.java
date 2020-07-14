package exo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        demoFlatMap();

        List<Animal> animaux = generationAnimaux();

        AnimalService animalService = AnimalService.getInstance();

        


    }
    public static void demoFlatMap(){
        List<List<Animal>> an = new ArrayList<>();
        an.add(new ArrayList<Animal>());
        an.add(new ArrayList<Animal>());

        an.get(0).add(new Animal("aa").ajoutRepas(1,3));
        an.get(0).add(new Animal("bb").ajoutRepas(5,7));

        an.get(1).add(new Animal("cc").ajoutRepas(2,4));
        an.get(1).add(new Animal("dd").ajoutRepas(6,8));

        List<Integer> heuresRepas = an.stream()
                .flatMap(a -> a.stream())
                .flatMap(a -> a.getRepas().stream())
                .collect(Collectors.toList());

        heuresRepas.forEach(h -> System.out.println(h));
    }
    public static List<Animal> generationAnimaux(){
        return Arrays.asList(
                new Animal("012")
                        .ajoutRepas(6,18)
                        .ajoutSoins(4,20),
                new Animal("007")
                        .ajoutRepas(7,12,19)
                        .ajoutSoins(10,19),
                new Animal("103")
                        .ajoutRepas(2,17,19)
                        .ajoutSoins(),
                new Animal("104")
                        .ajoutRepas()
                        .ajoutSoins(18,23),
                new Animal("010")
                        .ajoutRepas(14)
                        .ajoutSoins(14,15),
                new Animal("002")
                        .ajoutRepas(8,17,22)
                        .ajoutSoins(6,10,21)
        );
    }
}
