#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define max 2

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);
    
    float nota[max][2], media[max], mediaAluno, mediaSala;
    int i, j;

    for (i = 0; i < max; i++) {
        for (j = 0; j < 2; j++) {
            printf("%dº Aluno - %dª Nota: ", i + 1, j + 1);
            scanf("%f", & nota[i][j]);
        }
    }
    for (i = 0; i < max; i++) {
        for (j = 0; j < 1; j++) { 

            media[i] = (nota[i][j] + nota[i][j + 1]) / 2; 
        }
        mediaSala = mediaSala + media[i]; 
    }

    mediaSala = mediaSala / max;
    printf("\nA média da Sala é %.2f\n", mediaSala);
    for (i = 0; i < max; i++) {
        for (j = 0; j < 1; j++) {
            media[i] = (nota[i][j] + nota[i][j + 1]) / 2;
        }
        if (media[i] > mediaSala) {
            printf("%dº Aluno(a) - Média Final: %.2f - Situação: Acima da média\n", i + 1, media[i]);
        } else if (mediaAluno == mediaSala) {
            printf("%dº Aluno(a) - Média Final: %.2f - Situação: Igual a média\n", i + 1, media[i]);
        } else
            printf("%dº Aluno(a) - Média Final: %.2f - Situação: Abaixo da média\n", i + 1, media[i]);
    }

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}