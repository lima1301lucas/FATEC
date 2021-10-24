#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

	char texto[100];
    int i, c, conta = 0;

    printf("Digite uma frase: ");
    fgets(texto, 150, stdin);
    for (i = 0; texto[i] != '\0'; i++) {
        if (texto[i] == ' ') {
            conta++;
        }
    }
    printf("Número de palavras: %d \n",conta+1);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}