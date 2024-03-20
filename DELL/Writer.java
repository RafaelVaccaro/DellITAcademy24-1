import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    
    public static void Write(ArrayList <String> registros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registros.csv"))) {
            for (String dados : registros) {

                writer.write(dados + "\n");
                
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
