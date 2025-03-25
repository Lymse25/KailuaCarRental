import java.util.*;
public class TestDBP
{
    public static void main(String args[])
    {
        Dato peterF = new Dato(19521017);
        Bil peterBil = new Bil("HX42311",2004);
        Person peter = new Person("Peter Hansen","phdk@gmail.com",peterF);
        peter.addBil(peterBil);

        Dato oleF = new Dato(19530714);
        Bil oleBil = new Bil("CN83832",2012);
        Person ole = new Person("Ole Pedersen","opdk@gmail.com",oleF);
        ole.addBil(oleBil);

        Dato knudF = new Dato(19190609);
        Bil knudBil = new Bil("MA39604",1938);
        Person knud = new Person("Knud Petersen","kpdk@gmail.com",knudF);
        knud.addBil(knudBil);

        List<Person> personer;

        personer = new ArrayList<Person>();

        personer.addFirst(peter);
        personer.add(ole);
        personer.addLast(knud);

        for (int i = 0; i < personer.size(); i++)
            PersonPersistens.writePerson(personer.get(i));



    }
}
