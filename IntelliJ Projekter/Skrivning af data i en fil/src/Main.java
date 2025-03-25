import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Opret en liste af personer
        Person person1 = new Person("John", 30);
        Person person2 = new Person("Maria", 25);
        List<Person> personer = Arrays.asList(person1, person2);

        // Skriv personer til fil
        PersonerFil.skrivPersonerTilFil(personer);

        // Opret en liste af studerende
        Student student1 = new Student("Anna", 22, "Datalogi");
        Student student2 = new Student("Mikkel", 24, "Maskinlæring");
        List<Student> studerende = Arrays.asList(student1, student2);

        // Skriv studerende til fil
        StuderendeFil.skrivStuderendeTilFil(studerende);
    }
}