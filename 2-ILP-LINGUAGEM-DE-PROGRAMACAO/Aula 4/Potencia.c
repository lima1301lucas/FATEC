#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main(){
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int base, expoente, i, res;
  res = 1;
  
  printf("Informe o valor da base: ");
  scanf("%d",&base);
  printf("Informe o valor do expoente: ");
  scanf("%d",&expoente);

  if (base == 0){
    return 0;
  }

  for(i = 0; i < expoente; i++){
    res = res * base;
  }
  
  printf("%d elevado a %d é igual a %d\n", base, expoente, res);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}