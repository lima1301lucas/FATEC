#include <locale.h>
#include <stdio.h>
#include <windows.h>

int reverso(unsigned num) {
  int aux1;

  if (num < 10){
    return num;
  }
  else if (num >= 10){
    printf("%u", num % 10);
    printf("%u", reverso(num / 10));
  }
}

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);

  int num;
  printf("Digite um número: ");
  scanf("%d", &num);
  reverso(num);

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}