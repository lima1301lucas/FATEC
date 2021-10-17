#include <locale.h>
#include <stdio.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int num1, num2, resultado;

  printf("\nDigite o 1º número: ");
  scanf("%d", &num1);
  printf("\nDigite o 2º número: ");
  scanf("%d", &num2);

  resultado = funcMax(num1, num2);
  printf("O maior número é %d\n", resultado);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}

int funcMax(int a, int b) {
    if (a > b)
        return a;
    else 
        return b;
}