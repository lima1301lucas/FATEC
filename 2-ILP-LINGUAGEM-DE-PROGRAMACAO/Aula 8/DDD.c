// Prova feita por Bianca Goiano e Lucas Lima

#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  UINT CPAGE_DEFAULT = GetConsoleOutputCP();
  SetConsoleOutputCP(CPAGE_UTF8);
            
  int ddd; 
  printf ("\nDigite o DDD para discagem interurbana: "); 
  scanf ("%d", &ddd);
  
  switch (ddd){ 
    case 11: printf ("Local: São Paulo\n"); break; 
    case 19: printf ("Local: Campinas\n"); break; 
    case 21: printf ("Local: Rio de Janeiro\n"); break; 
    case 27: printf ("Local: Vitória\n"); break; 
    case 31: printf ("Local: Belo Horizonte\n"); break; 
    case 32: printf ("Local: Juiz de Fora\n"); break; 
    case 61: printf ("Local: Brasília\n"); break; 
    case 71: printf ("Local: Salvador\n"); break; 
    default : printf ("DDD não cadastrado!\n");
  }

  SetConsoleOutputCP(CPAGE_DEFAULT);
  system("pause");
  return 0;
}