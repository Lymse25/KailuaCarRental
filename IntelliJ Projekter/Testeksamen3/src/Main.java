public class Main {
    public static void main(String[] args) {
        Bilbutik bilbutik = new Bilbutik();

        bilbutik.tilfeoj(new Bil ("Toyota", "Corolla", 2022, 250000));
        bilbutik.tilfeoj(new Bil ("Mercedes", "GLC", 2024, 2500000));
        bilbutik.tilfeoj(new Bil ("BMW", "I8", 2021, 3500000));
        bilbutik.tilfeoj(new Bil ("Ford", "Billet", 2020, 3200000));

        System.out.println("Biler på lager");
        bilbutik.visbiler();

        Bil Dyreste = bilbutik.FindDyresteBil();
        if (Dyreste != null) {
            System.out.println("Dyreste bil er:");
            System.out.println(Dyreste);
        } else {
            System.out.println("Ingen biler på lager.");
        }
    }
}