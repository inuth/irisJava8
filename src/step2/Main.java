package step2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne("AAA", "Albert", "Rue du croisé, 2");
        Personne p2 = new Personne("BBB", "Bernard", "Rue du croisé, 2");
        Personne p3 = new Personne("CCC", "Camille", "Rue de la loi, 1");

        List<Personne> personnes = Arrays.asList(p1,p2,p3);



//        habitations = personnes.stream()
//                .map(p -> {
//                    Habitation habitation = new Habitation();
//                    habitation.setAdresse(p.getAdresse());
//                    return habitation;
//                })
//                .collect(Collectors.toList());

        List<Habitation> habitations = new ArrayList<>();

        // savoir si une habitation a la meme adresse que "h"
        personnes.stream()
                .filter(p -> habitations.stream()
                        .noneMatch(hab -> hab.getAdresse().equals(p.getAdresse())))
                .map(p -> {

                    System.out.println("CONSTRUCTION objet HABITATION");
                    Habitation habitation = new Habitation();
                    habitation.setAdresse(p.getAdresse());
                    return habitation;
                })
                .forEach(habitations::add);

        personnes.stream()
                // filter inutile dans ce cas-ci
                .filter(p -> habitations.stream()
                        .anyMatch(hab -> hab.getAdresse().equals(p.getAdresse())))
                // Là, nous avons TOUS les habitants dont l'adresse est présente
                // dans la liste des habitations.

                .forEach(p -> {
                    // BUT : ajouter la personne dans SON habitation

                    // trouver l'habitation de p
                    Habitation habitation = habitations.stream()
                            // on filtre pour n'avoir que les habitations
                            // qui ont la même adresse que la personne
                            .filter(h -> p.getAdresse().equals(h.getAdresse()))
                            .findFirst().get();

                    // IF inutile à cause du filter !
//                    if (habitation == null){
//                        Habitation habit = new Habitation();
//                        habit.setAdresse(p.getAdresse());
//                        habit.getHabitants().add(p);
//                        habitations.add(habit);
//                        p.getHabitations().add(habit);
//                    }
//                    else{
                        habitation.getHabitants().add(p);
//                    }
                });


        habitations.forEach(h -> System.out.println(h.getAdresse()));

        habitations.forEach(h -> System.out.println(h.getHabitants().size()));

        habitations.stream()
                .mapToInt(h -> h.getHabitants().size()) // IntStream
                .sum();

        System.out.println("\n------- COMPARATOR -----\n");
        habitations.stream()
                .sorted(Comparator.comparing(Habitation::getId))
                //.sorted(Comparator.comparingInt(s -> ((Habitation)s).getId()).reversed())
                .forEach(h -> System.out.println(h.getId()));


        System.out.println("fin");
        // filter
        // map

        // findFirst
        // foreach
        // collect

        // lambda
        // Optional
        // isPresent
        // orElse
        // get
    }
}
