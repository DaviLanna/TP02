package TP02;
import java.util.*;


public class InversaoString{
    private static String InverteString(String string){
        char[] aux = new char[string.length()];
        for(int i = 0; i < string.length(); i++){
            aux[i] = string.charAt(string.length() - i -1);
        }
        return new String(aux);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string;
        while(!(string = sc.nextLine().trim()).equals("FIM")){
            System.out.println(InverteString(string));
        }

        sc.close();
    }
}