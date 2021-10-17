#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  int faltas;
  printf("\nDigite o número de faltas: ");
  scanf("%d", &faltas);
  
  if (faltas > 5){
    printf("Conceito F \n");
  }
  else{
      float media;
      printf("Digite a média: ");
      scanf("%f", &media);

      if (media < 6.0){
        printf("Conceito C \n");
      }
      else{
        if (media >= 6.0 && media < 7.5){
            printf("Conceito B \n");              
        }
        else{
           if (media >= 7.5 && media < 9.0){
               printf("Conceito A \n");
           }
           else{
               printf("Conceito E \n");
           } 
        }
      }
    }
    
  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}