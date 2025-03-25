import java.util.ArrayList;

public class Bilbutik {
    // Liste til at gemme biler
    private ArrayList<Bil> biler;

    // Konstruktor
    public Bilbutik() {
        biler = new ArrayList<>();
    }

    // Metode til at tilføje bil til listen
    public void tilfeoj(Bil bil) {
        biler.add(bil);
    }

    // Metode til at finde den dyreste bil
    public Bil FindDyresteBil(){
        if (biler.isEmpty()){
            return null;  // Returner null hvis listen er tom
        }

        Bil DyresteBil = biler.get(0);
        for (Bil bil : biler){
            if (bil.getPris() > DyresteBil.getPris()){
                DyresteBil = bil;
            }
        }
        return DyresteBil;  // Returner den dyreste bil
    }

    // Metode til at vise alle biler
    public void visbiler() {
        for (Bil bil : biler) {
            System.out.println(bil);
        }
    }
}