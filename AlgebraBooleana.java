package TP02;
import java.util.*;

public class AlgebraBooleana {

    private static boolean avaliarExpressao(String entrada) {
        String[] partes = entrada.trim().split(" ");
        int n = Integer.parseInt(partes[0]);

        boolean[] valores = new boolean[n];
        for (int i = 0; i < n; i++) {
            valores[i] = partes[i + 1].equals("1");
        }

        StringBuilder expressao = new StringBuilder();
        for (int i = n + 1; i < partes.length; i++) {
            expressao.append(partes[i]);
            if (i < partes.length - 1) {
                expressao.append(" ");
            }
        }

        String expressaoSubstituida = substituirVariaveis(expressao.toString(), valores);

        return avaliar(expressaoSubstituida);
    }

    private static String substituirVariaveis(String expressao, boolean[] valores) {
        String resultado = expressao;
        for (int i = 0; i < valores.length; i++) {
            char variavel = (char) ('A' + i);
            String valorStr = valores[i] ? "1" : "0";
            resultado = resultado.replace(String.valueOf(variavel), valorStr);
        }
        return resultado;
    }

    private static boolean avaliar(String expressao) {
        expressao = expressao.trim();

        if (expressao.equals("0"))
            return false;
        if (expressao.equals("1"))
            return true;

        expressao = expressao.replaceAll("\\s+", " ");

        if (expressao.startsWith("not(")) {
            int fim = encontrarParenteseFechamento(expressao, 3);
            String subExpressao = expressao.substring(4, fim);
            return !avaliar(subExpressao);
        }

        if (expressao.startsWith("and(")) {
            return processarOperacaoBinaria(expressao, "and", true);
        }

        if (expressao.startsWith("or(")) {
            return processarOperacaoBinaria(expressao, "or", false);
        }

        return false;
    }

    private static boolean processarOperacaoBinaria(String expressao, String operacao, boolean isAnd) {
        int inicioArgs = operacao.length() + 1;
        int fimArgs = encontrarParenteseFechamento(expressao, operacao.length());

        String argumentos = expressao.substring(inicioArgs, fimArgs);
        List<String> operandos = separarOperandos(argumentos);

        if (isAnd) {
            for (String operando : operandos) {
                if (!avaliar(operando.trim())) {
                    return false;
                }
            }
            return true;
        } else {
            for (String operando : operandos) {
                if (avaliar(operando.trim())) {
                    return true;
                }
            }
            return false;
        }
    }

    private static int encontrarParenteseFechamento(String expressao, int inicio) {
        int contador = 0;
        for (int i = inicio; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '(') {
                contador++;
            } else if (c == ')') {
                contador--;
                if (contador == 0) {
                    return i;
                }
            }
        }
        return expressao.length() - 1;
    }

    private static List<String> separarOperandos(String argumentos) {
        List<String> operandos = new ArrayList<>();
        int nivel = 0;
        int inicio = 0;

        for (int i = 0; i < argumentos.length(); i++) {
            char c = argumentos.charAt(i);

            if (c == '(') {
                nivel++;
            } else if (c == ')') {
                nivel--;
            } else if (c == ',' && nivel == 0) {
                operandos.add(argumentos.substring(inicio, i).trim());
                inicio = i + 1;
            }
        }

        if (inicio < argumentos.length()) {
            operandos.add(argumentos.substring(inicio).trim());
        }

        return operandos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;

        // Verificar se há linha disponível antes de ler
        while (sc.hasNextLine() && !(entrada = sc.nextLine()).equals("0")) {
            boolean resultado = avaliarExpressao(entrada);
            System.out.println(resultado ? "1" : "0");
        }

        sc.close();
    }
}