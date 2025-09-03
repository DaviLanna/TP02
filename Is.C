#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

// Verifica se contém apenas vogais
bool X1(char *string) {
    for (int i = 0; string[i] != '\0'; i++) {
        char c = tolower(string[i]);
        if (!isalpha(c)) {
            return false;
        }
        if (strchr("aeiou", c) == NULL) {
            return false;
        }
    }
    return true;
}

// Verifica se contém apenas consoantes
bool X2(char *string) {
    for (int i = 0; string[i] != '\0'; i++) {
        char c = tolower(string[i]);
        if (!isalpha(c)) {
            return false;
        }
        if (strchr("aeiou", c) != NULL) {
            return false;
        }
    }
    return true;
}

// Verifica se é um número inteiro
bool X3(char *string) {
    int inicio = 0;
    if (string[0] == '-' || string[0] == '+') {
        if (strlen(string) == 1) return false; // só sinal não pode
        inicio = 1;
    }
    for (int i = inicio; string[i] != '\0'; i++) {
        if (!isdigit(string[i])) {
            return false;
        }
    }
    return true;
}

// Verifica se é um número real
bool X4(char *string) {
    int inicio = 0;
    bool temPonto = false;

    if (string[0] == '-' || string[0] == '+') {
        if (strlen(string) == 1) return false;
        inicio = 1;
    }

    for (int i = inicio; string[i] != '\0'; i++) {
        char c = string[i];
        if (c == '.' || c == ',') {
            if (temPonto) return false; // só pode ter um ponto/vírgula
            temPonto = true;
        } else if (!isdigit(c)) {
            return false;
        }
    }
    return true;
}

int main() {
    char string[1000];

    while (1) {
        fgets(string, sizeof(string), stdin);
        string[strcspn(string, "\n")] = '\0'; // remove newline

        if (strcmp(string, "FIM") == 0) break;

        printf("%s ", X1(string) ? "SIM" : "NAO");
        printf("%s ", X2(string) ? "SIM" : "NAO");
        printf("%s ", X3(string) ? "SIM" : "NAO");
        printf("%s\n", X4(string) ? "SIM" : "NAO");
    }

    return 0;
}
