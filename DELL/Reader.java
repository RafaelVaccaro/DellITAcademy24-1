import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private static String line = "";
    

    public static String read() {
        String c = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("registros.csv"))) {
           
            while ((line = reader.readLine()) != null) {

                
                String[] row = line.split(",");

                for (String i : row) {
                    c = c + i + "\n";
                }
                c = c + "\n";
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }
}
