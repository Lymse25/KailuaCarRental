
public class Main {
    public static void main(String[] args) {
        Bibliotek bibliotek = new Bibliotek();

        // Opretter bøger
        Bog bog1 = new Bog("Harry Potter", "J.K Rowling", 350);
        Bog bog2 = new Bog("Ringenes hære", "Lymae", 343);
        Bog bog3 = new Bog("rich dad poor dad", "hans", 758);
        Bog bog4 = new Bog("How to opføre sig ordentligt på arbejdet", "Hanna Maria Jensen", 1);

        // Tilføjer bøgerne til biblioteket
        bibliotek.tilfoejBog(bog1);
        bibliotek.tilfoejBog(bog2);
        bibliotek.tilfoejBog(bog3);
        bibliotek.tilfoejBog(bog4);

        // Printer bøgerne ud
        System.out.println(bog1);
        System.out.println(bog2);
        System.out.println(bog3);
        System.out.println(bog4);

        // Beregner og viser det samlede antal sider
        int samletAntalSider = bibliotek.samletAntalSider();
        System.out.println("Samlet antal sider i biblioteket: " + samletAntalSider);
    }
}