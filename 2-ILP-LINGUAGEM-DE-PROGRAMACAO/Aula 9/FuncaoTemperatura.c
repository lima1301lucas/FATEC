#include <stdio.h>
#include <locale.h>
#include <windows.h>
#define max 7

void obtem(float temp[]) {
    int i;
    printf("Digite as temperaturas\n");
    for (i = 0; i < max; i++) {
        printf("Temperatura: ", i + 1);
        scanf("%f", & temp[i]);
    }
}

float media(float temp[]) {
    int i;
    float media = 0;
    for (i = 0; i < max; i++) {
        media += temp[i];
    }
    return media / max;
}

int conta(float temp[], float mediaTemp) {
    int i, conta = 0;
    for (i = 0; i < max; i++) {
        if (temp[i] > mediaTemp)
            conta++;
    }
    return conta;
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    float temp[max], mediaTemp;
    obtem(temp);
    mediaTemp = media(temp);
    printf("\nA média de temperatura da semana foi: %.2f", mediaTemp);
    printf("\nO número de dias em que a temperatura ficou acima da média foi: %d \n", conta(temp, mediaTemp));

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}