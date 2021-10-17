#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  int numPlaca, ultNum; 
  printf ("Digite os 4 números da placa do carro: \n"); 
  scanf ("%d", &numPlaca); ultNum = numPlaca % 10; 
  printf ("O último digito da placa é: %d \n", ultNum); 
  
  switch (ultNum){ 
    case 1: printf ("O dia do rodízio e Segunda-feira. \n"); break; 
    case 2: printf ("O dia do rodízio e Segunda-feira. \n"); break; 
    case 3: printf ("O dia do rodízio e Terca-feira. \n"); break; 
    case 4: printf ("O dia do rodízio e Terca-feira. \n"); break; 
    case 5: printf ("O dia do rodízio e Quarta-feira. \n"); break; 
    case 6: printf ("O dia do rodízio e Quarta-feira. \n"); break; 
    case 7: printf ("O dia do rodízio e Quinta-feira. \n"); break; 
    case 8: printf ("O dia do rodízio e Quinta-feira. \n"); break; 
    case 9: printf ("O dia do rodízio e Sexta-feira. \n"); break; 
    case 0: printf ("O dia do rodízio e Sexta-feira. \n"); break; 
    default : printf ("Valor inválido!\n");
  }

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}