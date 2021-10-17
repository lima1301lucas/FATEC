// Prova feita por Bianca Goiano e Lucas Lima
#include <stdio.h>
#include <locale.h>
#include <windows.h>

int divide(int a, int b){
    if (b == 0){
        printf("\nNao é possível dividir por 0\n");
        return 0;
    }
    else{
        if (b == 1) return a;
        else{
            if (a < b) return 0;
            else return 1 + divide(a - b, b);
        }
    }
}

int main(){
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    int a, b;
    printf("\nDigite o valor de A: ");
    scanf("%d", &a);
    printf("Digite o valor de B: ");
    scanf("%d", &b);
    printf("\nResultado da divisão de %d por %d = %d\n", a, b, divide(a, b));

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}