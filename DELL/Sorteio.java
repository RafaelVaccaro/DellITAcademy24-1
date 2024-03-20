import java.util.Random;

public class Sorteio {
    
    private static String n1, n2, n3, n4, n5;
    private static int n1Int, n2Int, n3Int, n4Int, n5Int;
    private static Random random;
    private static String stringVazia = "";

    public static String sorteio() {
        random = new Random();
        boolean controle = true;

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
}
