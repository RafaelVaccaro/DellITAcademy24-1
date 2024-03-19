import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    
    public static void Read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("registros.csv"))) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
