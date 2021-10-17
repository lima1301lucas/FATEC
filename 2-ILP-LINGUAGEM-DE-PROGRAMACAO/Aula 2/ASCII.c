#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);
    
    char c;
    printf("Digite um caracter: ");
    scanf("%c", &c);
    
    printf("Caracter em Octal: %o \n", c);
    printf("Caracter em Decimal: %d \n", c);
    printf("Caracter em Hexadecimal: %x \n", c);
    
    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}