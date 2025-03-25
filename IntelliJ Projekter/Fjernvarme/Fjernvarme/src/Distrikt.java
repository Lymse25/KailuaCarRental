import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Distrikt {
    private List<Forbruger> forbrugere;
    private String navn;
    private float prisPerKubikmeter;

    public Distrikt(String navn, float prisPerKubikmeter) {
        this.navn = navn;
        this.prisPerKubikmeter = prisPerKubikmeter;
        this.forbrugere = new ArrayList<>();
    }

    public void genererForbrugere(int antal) {
        String[] pigeNavne = {"Emma", "Sofia", "Freja", "Ida", "Clara", "Luna", "Ella", "Olivia", "Alma", "Maja"};
        String[] drengeNavne = {"William", "Noah", "Oscar", "Lucas", "Emil", "Oliver", "Victor", "Alfred", "Elias", "Carl"};
        String[] efternavne = {"Hansen", "Jensen", "Nielsen", "Pedersen", "Andersen", "Kristensen", "Larsen", "Madsen", "Olsen", "Thomsen"};

        Random rand = new Random();

        for (int i = 0; i < antal; i++) {
            String fornavn = rand.nextBoolean() ?
                    pigeNavne[rand.nextInt(pigeNavne.length)] :
                    drengeNavne[rand.nextInt(drengeNavne.length)];

            String efternavn = efternavne[rand.nextInt(efternavne.length)];
            String fuldeNavn = fornavn + " " + efternavn;

            int maalerNr;
            do {
                maalerNr = rand.nextInt(999) + 1;
            } while (findesMaalerNr(maalerNr));

            int startForbrug = rand.nextInt(5000);
            int ekstraForbrug = rand.nextInt(200);

            Forbruger nyForbruger = new Forbruger(fuldeNavn, maalerNr, startForbrug, startForbrug + ekstraForbrug);
            addForbruger(nyForbruger);
        }
    }

    private boolean findesMaalerNr(int maalerNr) {
        for (Forbruger f : forbrugere) {
            if (f.getMaalerNr() == maalerNr) {
                return true;
            }
        }
        return false;
    }

    public void addForbruger(Forbruger forbruger) {
        forbrugere.add(forbruger);
    }

    public List<Forbruger> getForbrugere() {
        return forbrugere;
    }

    public float afregnForbruger(int maalerNr) {
        for (Forbruger forbruger : forbrugere) {
            if (forbruger.getMaalerNr() == maalerNr) {
                return forbruger.beregnForbrug() * prisPerKubikmeter;
            }
        }
        return -1;
    }

    public void tjekNavnefordeling() {
        int antalPiger = 0;
        int antalDrenge = 0;

        String[] pigeNavne = {"Emma", "Sofia", "Freja", "Ida", "Clara", "Luna", "Ella", "Olivia", "Alma", "Maja"};
        String[] drengeNavne = {"William", "Noah", "Oscar", "Lucas", "Emil", "Oliver", "Victor", "Alfred", "Elias", "Carl"};

        for (Forbruger forbruger : forbrugere) {
            String fornavn = forbruger.getNavn().split(" ")[0];

            if (java.util.Arrays.asList(pigeNavne).contains(fornavn)) {
                antalPiger++;
            } else if (java.util.Arrays.asList(drengeNavne).contains(fornavn)) {
                antalDrenge++;
            }
        }

        System.out.println("Antal piger: " + antalPiger);
        System.out.println("Antal drenge: " + antalDrenge);
    }

    public void tjekDuplikaterAfNavne() {
        HashMap<String, Integer> navneTæller = new HashMap<>();

        for (Forbruger forbruger : forbrugere) {
            String navn = forbruger.getNavn();
            navneTæller.put(navn, navneTæller.getOrDefault(navn, 0) + 1);
        }

        boolean harDuplikater = false;
        for (String navn : navneTæller.keySet()) {
            if (navneTæller.get(navn) > 1) {
                System.out.println(navn + " forekommer " + navneTæller.get(navn) + " gange.");
                harDuplikater = true;
            }
        }

        if (!harDuplikater) {
            System.out.println("Ingen duplikerede navne fundet.");
        }
    }

    public void sorterForbrugereAlfabetisk() {
        for (int i = 0; i < forbrugere.size() - 1; i++) {
            for (int j = 0; j < forbrugere.size() - i - 1; j++) {
                Forbruger f1 = forbrugere.get(j);
                Forbruger f2 = forbrugere.get(j + 1);
                if (f1.getNavn().compareToIgnoreCase(f2.getNavn()) > 0) {
                    forbrugere.set(j, f2);
                    forbrugere.set(j + 1, f1);
                }
            }
        }
    }

    // Metode til at udskrive forbrugere i målernummerinterval
    public void udskrivForbrugereIMaalerNrInterval(int lavMaalerNr, int hoejMaalerNr) {
        System.out.println("Forbrugere med målernummer i intervallet " + lavMaalerNr + "-" + hoejMaalerNr + ":");
        boolean found = false; // Variabel til at tjekke om nogen forbrugere blev fundet

        for (Forbruger forbruger : forbrugere) {
            int maalerNr = forbruger.getMaalerNr();
            if (maalerNr >= lavMaalerNr && maalerNr <= hoejMaalerNr) {
                System.out.println(forbruger);
                found = true; // Angiv at vi har fundet mindst én forbruger
            }
        }

        if (!found) {
            System.out.println("Ingen forbrugere fundet i dette interval.");
        }
    }
}