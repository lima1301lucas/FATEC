// Prova feita por Bianca Goiano e Lucas Lima
#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define convTemp(tempCelsius) ((tempCelsius * 9.0/5.0) + 32)

int main(){
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  float tempCel;
  printf("Digite a temperatura em Celsius: ");
  scanf("%f", &tempCel);
  printf("\n%.fº C é equivalente a %.fº F\n", tempCel, convTemp(tempCel));

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}