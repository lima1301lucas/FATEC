// Prova feita por Bianca Goiano e Lucas Lima
#include <stdio.h>
#include <locale.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    int gols_inter, gols_gremio, saldo_inter, saldo_gremio, partidas, novo_jogo, empates, vitorias_gremio, vitorias_inter;
	saldo_inter=0, saldo_gremio=0, partidas=0, empates=0, vitorias_gremio=0, vitorias_inter=0;
    
	printf("\nDigite o resultado do Grenal (Grêmio x Inter):\n");
    
    while(1)
    {
        scanf ("%d %d", &gols_gremio, &gols_inter);
        if(gols_inter > gols_gremio) vitorias_inter++;
        if(gols_inter < gols_gremio) vitorias_gremio++;
        if(gols_inter == gols_gremio) empates++;
        saldo_inter += gols_inter;
        saldo_gremio += gols_gremio;
        partidas++;
        printf("\nNovo grenal? (1-Sim 2-Não) ");
        scanf("%d",&novo_jogo);
        if(novo_jogo==1)
            continue;
        if(novo_jogo==2)
            break;
    }
    
	printf("\nOcorreram %d grenais",partidas);
	printf("\nO Inter venceu %d partidas",vitorias_inter);
	printf("\nO Grêmio venceu %d partidas",vitorias_gremio);
	printf("\nOcoreram %d empates",empates);
    
	if(vitorias_gremio==vitorias_inter)
    	printf("\nNão houve vencedor\n");
	if(vitorias_inter>vitorias_gremio)
    	printf("\nInter venceu mais\n");
	if(vitorias_inter<vitorias_gremio)
    	printf("\nGrêmio venceu mais\n");

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}