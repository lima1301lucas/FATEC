#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}