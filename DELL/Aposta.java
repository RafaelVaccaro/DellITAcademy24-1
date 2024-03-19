public class Aposta {
    private static String nome, cpf, n1, n2, n3, n4, n5;

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

        String aposta = n1+n2+n3+n4+n5;
        String[] registro = {nome, cpf, aposta};
        Writer.Write(registro);
    }
}
