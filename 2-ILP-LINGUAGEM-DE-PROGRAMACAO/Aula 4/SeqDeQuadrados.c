#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  while (1){
      int num;
      printf("\nDigite um número: ");
      scanf("%d", &num);
      
      if (num == 0){
          return 0;
      }
    
    printf("O quadrado de %d é %d", num, num * num);
  }

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}