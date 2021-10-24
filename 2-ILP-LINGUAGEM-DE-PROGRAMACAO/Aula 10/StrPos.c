#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <windows.h>

char srtpos(char stringS[], char buscaC){
  int i, tam;
  tam = strlen(stringS);

  for (i = 0; i < tam; i++) {
    if (stringS[i] == buscaC){
      return i;
    }
  }
  return -1;
}

int main(void) {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  int posicao;
  char stringS[100], buscaC;
  buscaC = 'c';
  printf("Digite uma frase: ");
  fgets(stringS, 100, stdin);
  posicao = srtpos(stringS, buscaC);

  if (posicao == -1) {
    printf("\nNão encontrado!\n");
  } else printf("\nEncontrado na posição %d \n", posicao);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}