#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  float a, b, c, x1, x2, delta;
  printf("Digite o valor de A: ");
  scanf("%f", &a);
  printf("Digite o valor de B: ");
  scanf("%f", &b);
  printf("Digite o valor de C: ");
  scanf("%f", &c);
  
  delta = b*b - 4*a*c;
   
  if(delta < 0){
      printf("A equação não possui raízes reais \n");
  } 
  else{
      x1 = (-b + sqrt(delta)) / (2*a);
      x2 = (-b - sqrt(delta)) / (2*a);

      printf("Delta = %.1f \n", delta);
      printf("X1 = %.2f \n", x1);
      printf("X2 = %.2f \n", x2);
  }
    
  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}