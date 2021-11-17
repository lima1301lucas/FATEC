#include <stdio.h>
#include <locale.h>
#include <windows.h>

typedef struct {
  char nome[21];
  char matricula[9];
  float mediaFinal;
} Aluno;

void LeALuno(Aluno alunos[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        printf("\nNome do aluno: ");
        gets(alunos[i].nome);

        printf("Número de matrícula do aluno: ");
        scanf("%s", &alunos[i].matricula, 9, stdin);

        printf("Média final do aluno: ");
        scanf("%f", &alunos[i].mediaFinal);
    }
}

void ImprimeAluno(Aluno alunos[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        printf("Nome: %s\n", alunos[i].nome);
        printf("Matrícula: %s\n", alunos[i].matricula);
        printf("Média final: %.2f\n", alunos[i].mediaFinal);
    }
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    int numAlunos = 5;
    Aluno alunos[numAlunos];
    LeALuno(alunos, numAlunos);
    ImprimeAluno(alunos, numAlunos);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}