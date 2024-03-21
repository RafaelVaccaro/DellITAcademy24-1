import java.util.ArrayList;
import java.util.Random;

public class Aposta {

    private static String n1, n2, n3, n4, n5, aposta, codigo;
    private static int n1Int, n2Int, n3Int, n4Int, n5Int;
    private static Random random;
    private static String stringVazia = "";
    private static int codigoInt = 1000;
    public static ArrayList<String> registros = new ArrayList<String>();

    public static void registrarAposta(String nome, String cpf, String n1, String n2, String n3, String n4, String n5) {

        aposta = n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5;
        codigo = codigoInt + stringVazia;
        String dados = nome + ", " + cpf + ", " + aposta + ", " + codigo;
        registros.add(dados);

        Writer.Write(registros);
        codigoInt++;

    }

    public static String surpresinha() {
        random = new Random();
        boolean controle = true;

        while (controle == true) {
            n1Int = random.nextInt(50) + 1;
            n2Int = random.nextInt(50) + 1;
            n3Int = random.nextInt(50) + 1;
            n4Int = random.nextInt(50) + 1;
            n5Int = random.nextInt(50) + 1;

            if (n1Int != n2Int && n1Int != n3Int && n1Int != n4Int && n1Int != n5Int && n2Int != n3Int && n2Int != n4Int
                    && n2Int != n5Int && n3Int != n4Int && n3Int != n5Int && n4Int != n5Int) {
                controle = false;
            }
        }

        n1 = n1Int + stringVazia;
        n2 = n2Int + stringVazia;
        n3 = n3Int + stringVazia;
        n4 = n4Int + stringVazia;
        n5 = n5Int + stringVazia;

        String aposta = n1 + " " + n2 + " " + n3 + " "  + n4 + " "  + n5;

        return aposta;
    }

    public static void registrarApostaSurpresa(String nome, String cpf, String apostaSurpresa) {

        codigo = codigoInt + stringVazia;
        String dados = nome + ", " + cpf + ", " + apostaSurpresa + ", " + codigo;
        registros.add(dados);

        Writer.Write(registros);
        codigoInt++;
    }
}
