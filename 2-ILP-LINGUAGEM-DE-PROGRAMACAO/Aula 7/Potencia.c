#include <locale.h>
#include <stdio.h>
#include <windows.h>

double potencia(double b, unsigned int e) {
  if (e == 0)
    return 1;
  else
    return (b * potencia(b, e - 1));
}

int main(void) {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  double base;
  unsigned int exponent;

  printf("Digite o valor da base: ");
  scanf("%lf", &base);

  printf("Digite o valor do expoente: ");
  scanf("%d", &exponent);

  double pow_result = potencia(base, exponent);
  printf("O resultado é: %.f\n", pow_result);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}