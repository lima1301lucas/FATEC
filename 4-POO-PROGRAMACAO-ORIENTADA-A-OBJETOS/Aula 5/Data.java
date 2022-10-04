private boolean bissexto(int anoTeste){

    if ((anoTeste % 4 == 0 && anoTeste % 100 != 0) || (anoTeste % 400 == 0)) return true;
    return false;
}

private int checkDia (int diaTeste){
    
    int diasMes[]= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    if (bissexto (ano)) 
        diasMes [2] = 29;
    
    if (diaTeste > 0 && diaTeste <= diasMes [mes])
        return diaTeste;
    
    System.out.println ("Dia " + diaTeste + " inválido. Configurado dia = 1."); return 1;
}