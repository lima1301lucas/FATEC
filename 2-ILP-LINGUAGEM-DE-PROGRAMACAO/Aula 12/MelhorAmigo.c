#include <stdio.h>
#include <locale.h>
#include <windows.h>

typedef struct{
    int dia;
    int mes;
    int ano;
}DATA;

typedef struct{
    char nome[31];
    char fone[21];
    DATA nasc;
}PESSOA;

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    PESSOA melhorAmigo;

    printf("Nome do melhor amigo: ");
    fgets(melhorAmigo.nome, 31, stdin);

    printf("Telefone do seu melhor amigo: ");
    scanf("%s", melhorAmigo.fone);

    printf("Data de nascimento (dd/mm/yyyy): ");
    scanf("%d/%d/%d", &melhorAmigo.nasc.dia, 
    &melhorAmigo.nasc.mes, 
    &melhorAmigo.nasc.ano);

    printf("\nInformações\n");
    printf("Nome: %s", melhorAmigo.nome);
    printf("Telefone: %s \n", melhorAmigo.fone);
    printf("Data de nascimento: %d/%d/%d \n",
    melhorAmigo.nasc.dia, melhorAmigo.nasc.mes, melhorAmigo.nasc.ano);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}