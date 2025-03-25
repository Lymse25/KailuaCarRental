import java.util.ArrayList;

// Classroom-klasse
class Classroom {
    private ArrayList<Student> students;

    public Classroom()
    {
        students = new ArrayList<>();
    }

    // Tilføj en ny studerende
    public void addStudent(String name, int age, double grade)
    {
        students.add(new Student(name, age, grade));
    }

    // Udskriv alle studerende
    public void printStudents()
    {
        System.out.println("Liste over studerende:");
        for (Student s : students)
        {
            System.out.println(s);
        }
    }

    // Beregn gennemsnit af karakterer
    public double calculateAverage()
    {
        double total = 0;
        for (Student s : students)
        {
            total += s.getGrade();
        }
        return students.size() > 0 ? total / students.size() : 0;
    }

    // Finder studerende med højest karakter
    public Student findTopStudent()
    {
        if (students.isEmpty())
        {
            return null;
        }
        Student topStudent = students.get(0);
        for (Student s : students)
        {
            if (s.getGrade() > topStudent.getGrade())
            {
                topStudent = s;
            }
        }
        return topStudent;
    }
}