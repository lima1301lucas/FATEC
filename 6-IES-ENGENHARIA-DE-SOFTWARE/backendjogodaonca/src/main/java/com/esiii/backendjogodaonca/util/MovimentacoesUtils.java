package com.esiii.backendjogodaonca.util;

import java.util.ArrayList;
import java.util.HashMap;

public class MovimentacoesUtils {

    public static ArrayList<String> getPosicoesValidas(ArrayList<String> posicoesInvalidas){

        ArrayList<String> posicoes = new ArrayList();
        for (int x =0; x <=6; x++){
            for (int y=0; y <=4; y++){
                posicoes.add(String.format("%s,%s;", x, y));
            }
        }
        posicoes.removeIf(posicaoValida -> posicoesInvalidas.stream()
                .anyMatch(posicaoInvalida -> posicaoInvalida.equalsIgnoreCase(posicaoValida)));
        return posicoes;
    }

    public static ArrayList<String> getPosicoesInvalidas() {
        ArrayList<String> posicoesInvalidas = new ArrayList();
        posicoesInvalidas.add("5,0;");
        posicoesInvalidas.add("5,4;");
        posicoesInvalidas.add("6,1;");
        posicoesInvalidas.add("6,3;");
        return posicoesInvalidas;
    }

    public static HashMap<String, String> getPosicoesCachorro(){
        HashMap<String, String> posicoes = new HashMap<>();
        posicoes.put("0,0;", "");
        posicoes.put("1,0;", "");
        posicoes.put("2,0;", "3,0;3,1;");
        posicoes.put("0,1;", "");
        posicoes.put("1,1;", "");
        posicoes.put("2,1;", "3,1;");
        posicoes.put("0,2;", "");
        posicoes.put("1,2;", "");
        posicoes.put("0,3;", "");
        posicoes.put("1,3;", "");
        posicoes.put("2,3;", "3,3;");
        posicoes.put("0,4;", "");
        posicoes.put("1,4;", "");
        posicoes.put("2,4;", "3,3;3,4;");

        return posicoes;
    }

    public static HashMap<String, String> getPosicoesOnca(){
        HashMap<String, String> posicoes = new HashMap<>();
        posicoes.put("2,2;", "3,1;3,2;3,3;");
        return posicoes;
    }
}
