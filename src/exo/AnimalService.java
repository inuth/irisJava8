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
}
