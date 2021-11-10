#include <stdio.h>
#include <locale.h>
#include <windows.h>

void minimax (float v[], int n, float *a, float *b){
    int j;
    *a = *b = v[0];

    for (j = 1; j < n; j++) {
        if (v[j] < * a)
            *a = v[j];
        if (v[j] > * b)
            *b = v[j];
    }
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    float v[] = {-3, -2, -1, 0, 1, 2, 3};
    float a, b;
    int tamanho = 7;
    
    minimax(v, tamanho, &a, &b);
    printf("Menor: %.1f e Maior: %.2f\n", a, b);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}