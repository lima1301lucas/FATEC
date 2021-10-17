/* Primeiro Programa: Elabore um programa em C que imprima seu minicurrículo (nome, idade, formação, profissão, tempo de experiência) */

#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  printf("\n ------------------------------Curriculum Vitae------------------------------ \n");
  printf("\nNome: Lucas Lima Oliveira\n");
  printf("Idade: 18 anos\n");
  printf("Formação: Técnico em Desenvolvimento de Sistemas - Etec (2020) \n\t  Análise e Desenvolvimento de Sistemas - Fatec (2020)\n");
  printf("Profissão: Trainee de TI \n");
  printf("Tempo de Experiência: 2 meses\n");
  printf("\n-----------------------------------------------------------------------------\n");

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}