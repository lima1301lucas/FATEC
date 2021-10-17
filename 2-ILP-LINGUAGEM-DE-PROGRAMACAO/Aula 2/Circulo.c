#include <stdio.h>
#include <locale.h>
#include <windows.h>
#include <math.h>
#define pi 3.1415

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  float raio, area, perimetro;
  printf("Digite o raio em metros: "); 
  scanf("%f", &raio);

  area = pi * (pow(raio, 2));
  printf("Área do círculo: %.2f m² \n", area);

  perimetro = 2 * pi * raio;
  printf("Perímetro do círculo: %.2f metros \n", perimetro);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}