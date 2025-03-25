public class main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        // Tilføj studerende
        classroom.addStudent("Lymae", 22, 10.5);
        classroom.addStudent("John", 25, 8.0);
        classroom.addStudent("Maria", 21, 12.0);
        classroom.addStudent("Jens", 22, 10.5);

        // Udskriv alle studerende
        classroom.printStudents();

        // Beregn gennemsnit af karakterer
        System.out.println("Gennemsnit af karakterer: " + classroom.calculateAverage());

        // Find studerende med højest karakter
        Student bestStudent = classroom.findTopStudent();
        System.out.println("Studerende med højest karakter: " + bestStudent.getName() + " med karakteren " + bestStudent.getGrade());
    }
}

