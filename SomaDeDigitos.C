#include <stdlib.h>
#include <stdio.h>

int Soma(int numero){
    if(numero == 0) return 0;
    return(numero % 10) + Soma(numero/10);
}
int main(){
    int numero;
    while(scanf("%d", &numero) == 1){
        printf("%d\n", Soma(numero));
    }
    return 0;
}