import java.util.ArrayList;

public class Bibliotek {
    private ArrayList<Bog> bibliotekList;

    // Konstruktor til initialisering af listen
    public Bibliotek() {
        bibliotekList = new ArrayList<>();
    }

    // Metode til at tilføje en bog til listen
    public void tilfoejBog(Bog bog) {
        bibliotekList.add(bog);
        System.out.println("Bogen '" + bog.getTitel() + "' er blevet tilføjet.");
    }

    // Metode til at beregne det samlede antal sider
    public int samletAntalSider() {
        // Opretter en variabel for det samlede antal sider
        int samletAntalSider = 0;

        // Går gennem alle bøgerne i biblioteket og tilføjer antallet af sider
        for (Bog bog : bibliotekList) {
            samletAntalSider += bog.getAntalSider(); // Øger den samlede værdi
        }

        // Returnerer det samlede antal sider
        return samletAntalSider;
    }
}