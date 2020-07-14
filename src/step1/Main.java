package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // interface fonctionnelle

        IOperation io = new IOperation() {
            @Override
            public int operation(int n1, int n2) {
                return 0;
            }
        };

        System.out.println(io.getClass());

        int resultat = faireOperation((n1, n2) -> n1 * n2 , 4, 7);

        // Les streams sont séparés en deux catégories de méthodes :
        // - celles qui continuent le stream
        // - celles qui en mettent fin
        List<Integer> ints = new ArrayList(){{add(1); add(2);add(3);add(4);}};
        // on ouvre le stream
        List<Integer> resultStream = ints.stream()
                // on va filtrer chaque element
                .filter(entier -> entier > 2)
                // on va transformer les résultats en liste
                .collect(Collectors.toList());

        resultStream.forEach(System.out::println);

        Personne p1 = new Personne("Sponge", "Bob", "Under the sea", "05484884");
        Personne p2 = new Personne("Belier", "Jacques", "Rue des croisés", "433544");
        Personne p3 = new Personne("Potier", "Cedric", "Sushi street", "47348");

        List<Personne> personnes = new ArrayList<>();
        personnes.add(p1);
        personnes.add(p2);
        personnes.add(p3);

        int x = 5;
        Stream<Info> streamInfo = personnes.stream() // Stream<step1.Personne>
                // transformer chaque step1.Personne en step1.Info
                .map(p -> {
//                    x++;
//                    ints.add(4);
                    System.out.println("Transformation de " + p.getNom() + " " + p.getPrenom());
                    Info info = new Info();
                    info.setAdresse(p.getAdresse());
                    info.setNumero(p.getNum());
                    return info;
                }); // Stream<step1.Info>
                // Filtrer les infos
                //.filter(i -> i.getNumero().length()>6);
        System.out.println("Coucou");

        // récupérer le résultat sous forme de liste
        List<Info> infos = streamInfo.collect(Collectors.toList());

        infos.forEach(i -> System.out.println(i.getAdresse()));

        // ADRESSE | NUMERO
        System.out.println(" --------- \n");

        Optional<String> str = infos.stream()
                .map(i -> {
                    System.out.println("map de " + i.getAdresse());
                    return i.getAdresse() + " | " + i.getNumero();}) // Stream<String>
                // récupère le premier élément qui a "réussi" a "traversé" le stream
                // très souvent utilisé avec une filter avant
                .findFirst();

        // Un optional contient une valeur ou pas
        // orElse va renvoyer la valeur présente et me renvoyer
        // la valeur par défaut (donnée en paramètre du orElse)
        // si il n'y en a pas
        String strValue = str.orElse(null);
        if (strValue != null){
            System.out.println(strValue);
        }
        // isPresent renvoie un boolean disant si la valeur est présente ou pas
        if (str.isPresent()){
            // get récupère la valeur dans le optional
            // renvoie une exception si aucune valeur n'est présente
            System.out.println(str.get());
        }






    }

    public static int faireOperation (IOperation operation, int n1, int n2){
        return operation.operation(n1, n2);
    }

    public static int plus (int nb1, int nb2){
        return nb1 + nb2;
    }

    public static int moins (int nb1, int nb2){
        return nb1 - nb2;
    }
}
