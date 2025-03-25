import java.util.ArrayList;

public class NavneListe {
    private ArrayList<String> navne;

    public NavneListe() {
        navne = new ArrayList<>();
    }

    public void tilfoejNavn(String navn) {
        navne.add(navn);
    }

    public void fjernNavn(String navn) {
        navne.remove(navn);
    }

    public void udskrivListe() {
        System.out.println("Navne på listen:");
        for (String navn : navne) {
            System.out.println(navn);
        }
    }
}