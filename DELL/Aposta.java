import java.util.Random;

public class Aposta {

    private static String nome, cpf, n1, n2, n3, n4, n5, aposta;
    private static int n1Int, n2Int, n3Int, n4Int, n5Int;
    private static Random random;
    private static String stringVazia = "";
    private static boolean controle = true;

    public static void setNome(String a) {
        nome = a;
    }

    public static void setCpf(String a) {
        cpf = a;
    }
    
    public static void setN1(String a) {
        n1 = a;
    }

    public static void setN2(String a) {
        n2 = a;
    }

    public static void setN3(String a) {
        n3 = a;
    }

    public static void setN4(String a) {
        n4 = a;
    }

    public static void setN5(String a) {
        n5 = a;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static String getN1() {
        return n1;
    }

    public static String getN2() {
        return n2;
    }

    public static String getN3() {
        return n3;
    }

    public static String getN4() {
        return n4;
    }

    public static String getN5() {
        return n5;
    }

    public static void registrarAposta(String nome, String cpf, String n1, String n2, String n3, String n4, String n5) {

        aposta = n1+n2+n3+n4+n5;
        String[] registro = {nome, cpf, aposta};
        Writer.Write(registro);
        
    }

    public static String surpresinha() {
        random = new Random();

        while (controle == true) {
            n1Int = random.nextInt(50) + 1;
            n2Int = random.nextInt(50) + 1;
            n3Int = random.nextInt(50) + 1;
            n4Int = random.nextInt(50) + 1;
            n5Int = random.nextInt(50) + 1;

            if (n1Int != n2Int && n1Int != n3Int && n1Int != n4Int && n1Int != n5Int && n2Int != n3Int && n2Int != n4Int && n2Int != n5Int && n3Int != n4Int && n3Int != n5Int && n4Int != n5Int) {
                controle = false;
            }
        }
        
        n1 = n1Int + stringVazia;
        n2 = n2Int + stringVazia;
        n3 = n3Int + stringVazia;
        n4 = n4Int + stringVazia;
        n5 = n5Int + stringVazia;

        String aposta = n1+n2+n3+n4+n5;
        
        return aposta;
    }

    public static void registrarApostaSurpresa(String nome, String cpf, String apostaSurpresa) {

        String[] registro = {nome, cpf, apostaSurpresa};
        Writer.Write(registro);
    }
}
