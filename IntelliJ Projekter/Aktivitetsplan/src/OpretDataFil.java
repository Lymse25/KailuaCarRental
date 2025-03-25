import java.io.FileWriter;
import java.io.IOException;

public class OpretDataFil {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("1;A;3\n");
            writer.write("1;B;6\n");
            writer.write("1;C;4\n");
            writer.write("2;D;5\n");
            writer.write("3;E;4\n");
            writer.write("3;F;1\n");
            writer.write("4;G;2\n");
            writer.write("4;H;7\n");
            writer.write("4;I;1\n");
            writer.write("5;J;4\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}