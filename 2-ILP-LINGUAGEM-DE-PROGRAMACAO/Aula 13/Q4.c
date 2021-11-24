//Feito por Bianca Goiano e Lucas Lima

#include <stdio.h>
#include <locale.h>
#include <windows.h>
#include "./Q3.h"

void LeConsulta(CONSULTA ag[], int n) {
    int i;

    for (i = 0; i < n; i++) {
        printf("\nEspecialidade medica: ");
        fgets(ag[i].esp_med, 40, stdin);
        printf("Nome: ");
        gets(ag[i].nome);
        printf("Convenio: ");
        gets(ag[i].convenio);
        printf("Dia, mes e ano da consulta: ");
        scanf("%d/%d/%d", & ag[i].consulta.dia, & ag[i].consulta.mes, & ag[i].consulta.ano);
        printf("Horas e minuto da consulta: ");
        scanf("%d:%d%*c", & ag[i].inicio.hora, & ag[i].inicio.minutos);
    }
}

void ImprimeConsulta(CONSULTA ag[], int n) {
    int i;

    printf("\n----- Visualização -----\n");
    for (i = 0; i < n; i++) {
        printf("\nEspecialidade medica: %s", ag[i].esp_med);
        printf("\nNome: %s", ag[i].nome);
        printf("\nConvenio: %s", ag[i].convenio);
        printf("\nData da consulta: %d/%d/%d", ag[i].consulta.dia, ag[i].consulta.mes, ag[i].consulta.ano);
        printf("\nHora da consulta: %d:%d\n", ag[i].inicio.hora, ag[i].inicio.minutos);
    }
    printf("\n----- Finalização -----\n");
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    CONSULTA agenda[2];
	LeConsulta(agenda, 2);
	ImprimeConsulta(agenda, 2);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}