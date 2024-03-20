import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    
    public static void Write(String[] registros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registros.csv"))) {
            for (String dados : registros) {
                writer.write(dados + ", ");
                
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
