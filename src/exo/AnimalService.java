package exo;

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
    
    // récupérer tous les animaux du rez-de-chaussée

    // récupérer les animaux ayant besoin du plus d'attention

    // récupérer la liste de soins de tous les animaux
    // -> le retour doit être : List<Integer>

    // récupérer la liste triée par ordre de priorité
    // la méthode prend un Integer en paramètre (représentant l'heure actuelle)


}
