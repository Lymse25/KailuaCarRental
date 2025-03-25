import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonPersistens
{
    public static void writePerson(Person p)
    {
        String personFile = "person.txt"; //navnet på output-filen

        try (FileWriter writer = new FileWriter(personFile))
        {
            String navn = p.getNavn();
            String mail = p.getMail();
            int fDag    = p.getFoedselsdag().getDatoen();
            String regNr= p.getBil().getRegistreringsNummer();
            int aargang = p.getBil().getAargang();

            writer.append(navn+",");
            writer.append(mail+",");
            writer.append(Integer.toString(fDag)+",");
            writer.append(regNr+",");
            writer.append(Integer.toString(aargang)+'\n');

            System.out.println("Person file written successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void readPerson()
    {
        // Skilletegn mellem atributter er et komma
        String komma = ",";
        String line = "";
        String personFile = "person.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Read each line from the file
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(komma);

                // Print the data
                System.out.println("Navn: " + data[0] + ", Mail: " + data[1] + ", F.dag: " + data[2]+", RegNr: " + data[3] + ", Aargang: " + data[4]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //writer.append(p.getNavn()+","+p.getMail()+","+Integer.toString(p.getFoedselsdag().getDatoen())+","+p.getBil().getRegist
}
   