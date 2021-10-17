#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  int num;
  printf("\nDigite um número: ");
  scanf("%d", &num);
  printf("%s", (num % 2) == 0 ? "Par \n":"Ímpar \n");
    
  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}