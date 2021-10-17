#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define soma(x, y) ( x + y )
#define max(x, y) ( x > y ? x : y )
#define abs(n) ( n < 0 ? -n : n )

int main(){
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int n1 = -7;
  int n2 =  8;
  
  printf("\n %d ", soma( 2 * 3, 1 + 3 ));
  printf("\n %d ", abs(n1));
  printf("\n %d ", max(n1, n2));

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}