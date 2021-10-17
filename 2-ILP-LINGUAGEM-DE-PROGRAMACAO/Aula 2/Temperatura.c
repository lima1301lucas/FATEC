#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  float TempCel, TempFahr;

  printf("Digite a temperatura em Fahrenheit: ");
  scanf("%f", &TempFahr);

  TempCel = (TempFahr - 32) * 5 / 9;
  printf("%.fº Graus Fahrenheit é equivalente a %.fº Graus Celsius \n", TempFahr, TempCel);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}