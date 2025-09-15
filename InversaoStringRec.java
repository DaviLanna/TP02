import java.util.*;

public class InversaoStringRec {
    private static String Inverte(String string, int inicio, int fim){
        char[] aux = string.toCharArray();
        if(inicio >= fim){
            return new String(aux); //caso base
        }
        else{
            char temp = aux[inicio];
            aux[inicio] = aux[fim];
            aux[fim] = temp;
            return Inverte(new String(aux), inicio + 1, fim - 1);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string;
        while(!(string = sc.nextLine().trim()).equals("FIM")){
            System.out.println(Inverte(string, 0, string.length() - 1));
        }
        sc.close();
    }
}
