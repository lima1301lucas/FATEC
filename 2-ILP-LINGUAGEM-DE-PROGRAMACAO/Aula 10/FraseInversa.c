#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define max 51

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    char str[max], copia[max];
    int i = 0, compstr;

    printf("\nDigite uma palavra: ");
    gets(str);

    for (compstr = 0; str[compstr]; compstr++);
    while (str[i] != '\0') {
        copia[i] = str[compstr - i - 1];
        i++;
    }
    copia[i] = '\0';
    printf("\nPalavra Invertida: %s\n", copia);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}