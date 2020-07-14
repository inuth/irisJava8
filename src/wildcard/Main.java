package wildcard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<? extends Personne> personnes = new ArrayList<>();

        List<Salarie> salaries = new ArrayList<>();

        personnes = salaries;
    }
}
