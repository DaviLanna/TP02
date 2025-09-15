import java.util.Scanner;

public class SomaDeDigitosRec {
    public static int Soma(int numero) {
        if (numero == 0) {
            return 0;
        }
        return (numero % 10) + Soma(numero / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int numero = sc.nextInt();
            System.out.println(Soma(numero));
        }

        sc.close();
    }
}
