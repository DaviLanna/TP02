#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool X1_rec(char *string, int i) {
    if (string[i] == '\0') return true; // chegou ao fim
    char c = tolower(string[i]);
    if (!isalpha(c)) return false;
    if (strchr("aeiou", c) == NULL) return false;
    return X1_rec(string, i + 1);
}
bool X1(char *string) {
    return X1_rec(string, 0);
}

bool X2_rec(char *string, int i) {
    if (string[i] == '\0') return true;
    char c = tolower(string[i]);
    if (!isalpha(c)) return false;
    if (strchr("aeiou", c) != NULL) return false;
    return X2_rec(string, i + 1);
}
bool X2(char *string) {
    return X2_rec(string, 0);
}

bool X3_rec(char *string, int i) {
    if (string[i] == '\0') return true;
    if (!isdigit(string[i])) return false;
    return X3_rec(string, i + 1);
}
bool X3(char *string) {
    int inicio = 0;
    if (string[0] == '-' || string[0] == '+') {
        if (strlen(string) == 1) return false; // só sinal não pode
        inicio = 1;
    }
    return X3_rec(string, inicio);
}

bool X4_rec(char *string, int i, bool temPonto) {
    if (string[i] == '\0') return true;

    char c = string[i];
    if (c == '.' || c == ',') {
        if (temPonto) return false;
        return X4_rec(string, i + 1, true);
    } else if (!isdigit(c)) {
        return false;
    }
    return X4_rec(string, i + 1, temPonto);
}
bool X4(char *string) {
    int inicio = 0;
    if (string[0] == '-' || string[0] == '+') {
        if (strlen(string) == 1) return false;
        inicio = 1;
    }
    return X4_rec(string, inicio, false);
}

int main() {
    char string[1000];

    while (1) {
        fgets(string, sizeof(string), stdin);
        string[strcspn(string, "\n")] = '\0';

        if (strcmp(string, "FIM") == 0) break;

        printf("%s ", X1(string) ? "SIM" : "NAO");
        printf("%s ", X2(string) ? "SIM" : "NAO");
        printf("%s ", X3(string) ? "SIM" : "NAO");
        printf("%s\n", X4(string) ? "SIM" : "NAO");
    }

    return 0;
}
