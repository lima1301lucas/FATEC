// Prova feita por Bianca Goiano e Lucas Lima
#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define area(base, altura) ( base * altura )

int main(){
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  float base, altura;
  printf("Digite o valor da base: ");
  scanf("%f", &base);
  printf("Digite o valor da altura: ");
  scanf("%f", &altura);
  printf("\nA área do retângulo é: %.2f m²\n", area(base, altura));

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}