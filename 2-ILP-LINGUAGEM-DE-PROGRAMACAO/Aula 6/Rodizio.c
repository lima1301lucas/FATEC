#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  int placa;
  printf("Digite os 4 números da placa do carro:\n");
  scanf("%d", &placa);
  funcRodizio(placa);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}

void funcRodizio(int placa){
  
  switch (placa % 10){
  case 1:
  case 2: printf ("O dia do rodízio e Segunda-feira. \n"); break; 
  case 3:
  case 4: printf ("O dia do rodízio e Terca-feira. \n"); break; 
  case 5:
  case 6: printf ("O dia do rodízio e Quarta-feira. \n"); break; 
  case 7:
  case 8: printf ("O dia do rodízio e Quinta-feira. \n"); break;
  case 9:
  case 0: printf ("O dia do rodízio e Sexta-feira. \n"); break; 
  default : printf ("Valor inválido!\n");
  }

}