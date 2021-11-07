#include <stdio.h>
#include <locale.h>
#include <windows.h>

int ordena(int *a, int *b) {
    
    int menor, maior;
    if(*a < *b){
        menor = *a;
        maior = *b;
        return printf("A = %d e B = %d", menor, maior);
    }
    else{
        menor = *b;
        maior = *a;
        return printf("A = %d e B = %d", menor, maior);
    }
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

	int a, b;
	printf("Digite dois números inteiros: ");
	scanf("%d %d", &a, &b);
	ordena( &a, &b);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}