#include <locale.h>
#include <stdio.h>
#include <windows.h>

int produto( unsigned int a, unsigned int b ) {
    if (b == 0 || a == 1)
        return 0;
    else
        return (a + produto(a, b - 1));
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    unsigned int a, b, c;

    printf("Digite o primeiro número: ");
    scanf("%d", & a);
    printf("Digite o segundo número: ");
    scanf("%d", & b);
    
    c = produto(a,b); 

    printf("O produto é: %d\n", c);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}