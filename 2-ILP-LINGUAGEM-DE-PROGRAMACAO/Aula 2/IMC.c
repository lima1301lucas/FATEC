#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  float imc, altura, peso;
  printf("Cálculo de IMC");
  printf("\nDigite sua peso: ");
  scanf("%f", &peso);
  printf("Digite sua altura: ");
  scanf("%f",&altura);

  imc = peso/(altura*altura);

  printf("Seu IMC é = %.2f\n", imc);
  
  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}