// Student-klasse
class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade)
    {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName()
    {
        return name;
    }

    public double getGrade()
    {
        return grade;
    }

    @Override
    public String toString()
    {
        return "Navn: " + name + ", Alder: " + age + ", Karakter: " + grade;
    }
}
