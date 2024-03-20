import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private static String line = "";

    public static void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("registros.csv"))) {
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                for (String i : row) {
                    System.out.print(i);
                }
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
