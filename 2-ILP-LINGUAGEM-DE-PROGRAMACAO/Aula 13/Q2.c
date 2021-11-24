//Feito por Bianca Goiano e Lucas Lima

#include <stdio.h>
#include <locale.h>
#include <windows.h>

void strdel(char s[], int p){
	strcpy (s+p, s+p+1);
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    char s[] = "Lorem Ipsum";
	printf("Antes: %s", s);
	strdel(s,3);
	printf("\nDepois: %s\n", s);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}