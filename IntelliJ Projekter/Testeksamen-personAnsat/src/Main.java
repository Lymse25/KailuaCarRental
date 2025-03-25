public class Main {
    public static void main(String[] args) {
        Person person = new Person ("John", 30);
        Ansat ansat = new Ansat ("Maria", 30, 50000, "Manager");
        System.out.println(person.getNavn()+ " er " + person.getAlder()+" år gammel");
        System.out.println(ansat.getNavn()+ " er " + ansat.getAlder()+" år gammel");

    }

}
