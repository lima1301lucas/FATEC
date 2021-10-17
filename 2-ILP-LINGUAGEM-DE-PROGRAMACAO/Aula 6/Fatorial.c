#include <locale.h>
#include <stdio.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int num, fat;

  printf("\nDigite um número: ");
  scanf("%d", &num);
  fat = funcFat(num);

  printf("O fatorial de %d é %d\n", num, fat);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}

int funcFat(int num) {
  int cont = 1, fat = 1;

  while (cont <= num) {
    fat = fat * cont;
    cont++;                    
  }
  return fat;
}