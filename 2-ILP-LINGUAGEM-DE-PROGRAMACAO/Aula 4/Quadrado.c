#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main(){
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int cont, num, soma, quadrado;
  quadrado = 0;
  cont = 0;
  soma = 1;

  printf("Digite um número: ");
  scanf("%d",&num);  

  while(cont < num) {
    quadrado += soma;
    soma += 2;
    cont++;
  }

  printf("O quadrado de %d é igual a %d \n", num, quadrado); 

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}