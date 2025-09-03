package TP02;
import java.util.*;

public class Anagramas {
    public static boolean VerificaAnagrama(String string){
        String[] partes = string.split(" - ");
        String palavra1 = partes[0];
        String palavra2 = partes[1];

        // se forem diferentes, ja nao e anagrama

        if(palavra1.length() != palavra2.length()){
            return false;
        }

        int contador1 = 0;
        int contador2 = 0;

        // 2 for's, vao rodar as 2 strings e incrementar os contadores de cada uma baseado na tabela asc2

        for(int i = 0; i < palavra1.length(); i++){
            contador1 += palavra1.charAt(i);
        }

        for(int i = 0; i < palavra2.length(); i++){
            contador2 += palavra2.charAt(i);
        }
        
        //verifica se os contadores sao iguais
        if(contador1 != contador2){ 
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;
        while(!(string = sc.nextLine()).equals("FIM")){
            System.out.println(VerificaAnagrama(string) ? "SIM" : "NÃO");
        }
        sc.close();
    }
}
