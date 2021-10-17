#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int cont, num, fat;
  fat = 1;
  cont = 1;

  printf("\nDigite um número: ");
  scanf("%d", &num);

  while (cont <= num) {
    fat = fat * cont;
    cont++;                    
  }

  printf("O fatorial de %d é %d\n", num, fat);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}