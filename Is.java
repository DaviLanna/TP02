package TP02;
import java.util.*;

public class Is {
    // Verifica se contém apenas vogais
    private static boolean X1(String string){
        string = string.toLowerCase();
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }
            if("aeiou".indexOf(c) == -1){
                return false;
            }  
        }
        return true;
    }

    // Verifica se contém apenas consoantes
    private static boolean X2(String string){
        string = string.toLowerCase();
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }
            if("aeiou".indexOf(c) != -1){
                return false;
            }  
        }
        return true;
    }

    // Verifica se é um número inteiro
    private static boolean X3(String string){
        int inicio = 0;
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) return false; //Só sinal não pode
            inicio = 1;
        }
        for (int i = inicio; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Verifica se é um número real
    private static boolean X4(String string){
        int inicio = 0;
        boolean temPonto = false;
        
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) return false;
            inicio = 1;
        }
        
        for (int i = inicio; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c == '.' || c == ','){
                if(temPonto) return false; // Só pode ter um ponto/vírgula
                temPonto = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String string;
        while(!(string = sc.nextLine()).equals("FIM")){
            System.out.print(X1(string) ? "SIM " : "NAO ");
            System.out.print(X2(string) ? "SIM " : "NAO ");
            System.out.print(X3(string) ? "SIM " : "NAO ");
            System.out.println(X4(string) ? "SIM" : "NAO");
        }
        sc.close();
    }
}
