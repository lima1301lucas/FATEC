package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.enumerator.TipoJogadorEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.esiii.backendjogodaonca.util.MovimentacoesUtils.getPosicoesValidas;

@Service
public class MovimentacoesUseCase {
    public String getPossiveisPosicoes(String posicao, ArrayList<String> posicoesInvalidas, TipoJogadorEnum tipoJogador){
        ArrayList<String> posicoesValidas = getPosicoesValidas(posicoesInvalidas);
        ArrayList<String> posicoesPossiveis = new ArrayList<>();
        Integer posicaoAtualX = Integer.parseInt(posicao.substring(0,1));
        Integer posicaoAtualY = Integer.parseInt(posicao.substring(2,3));

        Boolean estaNoTriangulo = (posicaoAtualX == 5 || posicaoAtualX == 6 ? Boolean.TRUE : Boolean.FALSE);
        Integer extremidadeDiagonal = 6;
        Integer extremidadeVertical = 4;
        Integer extremidadeHorizontal = (posicaoAtualY != 2 ? 4 : 6);

        if(estaNoTriangulo){
            switch (posicao){
                case "6,0;":
                    posicoesPossiveis.addAll(getMovimentacoesDiagonalSuperiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                    if(TipoJogadorEnum.ONCA.equals(tipoJogador)
                            && isOcupado(posicoesInvalidas, "6,2;")
                            && !isOcupado(posicoesInvalidas, "6,4;")){
                        posicoesPossiveis.add("6,4;");
                    } else posicoesPossiveis.add("6,2;");
                    break;
                case "5,1;":
                    posicoesPossiveis.addAll(getMovimentacoesDiagonalSuperiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                    break;
                case "6,4;":
                    posicoesPossiveis.addAll(getMovimentacoesDiagonalInferiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                    if(TipoJogadorEnum.ONCA.equals(tipoJogador)
                            && isOcupado(posicoesInvalidas, "6,2;")
                            && !isOcupado(posicoesInvalidas, "6,0;")){
                        posicoesPossiveis.add("6,0;");
                    }else posicoesPossiveis.add("6,2;");
                    break;
                case "5,3;":
                    posicoesPossiveis.addAll(getMovimentacoesDiagonalInferiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                    break;
                case "6,2;":
                    posicoesPossiveis.add("6,0;");
                    posicoesPossiveis.add("6,4;");
                    break;
            }
        }else{
            if(((posicaoAtualX%2 == 0) && (posicaoAtualY%2 == 0)) || ((posicaoAtualX%2 == 1) && (posicaoAtualY%2 == 1))){
                posicoesPossiveis.addAll(getMovimentacoesDiagonalSuperiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                posicoesPossiveis.addAll(getMovimentacoesDiagonalInferiorEsquerda(posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
                if(!posicao.equals("4,4;")) posicoesPossiveis
                        .addAll(getMovimentacoesDiagonalInferiorDireita(posicaoAtualX, posicaoAtualY, extremidadeDiagonal, tipoJogador, posicoesInvalidas));
                if(!posicao.equals("4,0;")) posicoesPossiveis
                        .addAll(getMovimentacoesDiagonalSuperiorDireita(posicaoAtualX, posicaoAtualY, extremidadeDiagonal, tipoJogador, posicoesInvalidas));
            }
        }
        if(!posicao.equals("6,0;") && !posicao.equals("6,4;") && !posicao.equals("5,1;") && !posicao.equals("5,3;")) posicoesPossiveis
                .addAll(getMovimentacoesHorizontal(extremidadeHorizontal, posicaoAtualX, posicaoAtualY, tipoJogador, posicoesInvalidas));
        posicoesPossiveis.addAll(getMovimentacoesVertical(posicaoAtualX, posicaoAtualY, extremidadeVertical, tipoJogador, posicoesInvalidas));

        posicoesPossiveis.removeIf(posicaoPossivel -> posicoesValidas.stream()
                .noneMatch(posicaoValida -> posicaoValida.equalsIgnoreCase(posicaoPossivel)));
        String posicoesPossiveisResult = new String();

        for (String posicaopossivel: posicoesPossiveis) {
            posicoesPossiveisResult = posicoesPossiveisResult + posicaopossivel;
        }
        return posicoesPossiveisResult;
    }

    private Boolean isOcupado(ArrayList<String> posicoesInvalidas, String posicao){
        if (posicoesInvalidas.stream().anyMatch(posicao::equals)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    private ArrayList<String> getMovimentacoesDiagonalSuperiorEsquerda(Integer x, Integer y, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();

        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            x--;
            y++;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            for (int xcontador = x; (xcontador >= (x-4) || xcontador >= 0); xcontador-=2){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-1, y+1))){
                    if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-2, y+2))){
                        return posicoesPossiveis;
                    }else {
                        posicoesPossiveis.add(String.format("%s,%s;", xcontador-2, y+2));
                    }
                }else if (xcontador == x){
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador-1, y+1));
                    return posicoesPossiveis;
                } else {
                    return posicoesPossiveis;
                }
                y+=2;
            }
        }
        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacoesDiagonalSuperiorDireita(Integer x, Integer y, Integer extremidadeDiagonal, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();

        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            x++;
            y++;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            for (int xcontador = x; (xcontador <= (x+4) || xcontador <= extremidadeDiagonal); xcontador+=2){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+1, y+1))){
                    if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+2, y+2))){
                        return posicoesPossiveis;
                    }else {
                        posicoesPossiveis.add(String.format("%s,%s;", xcontador+2, y+2));
                    }
                }else if (xcontador == x){
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador+1, y+1));
                    return posicoesPossiveis;
                }else {
                    return posicoesPossiveis;
                }
                y+=2;
            }
        }

        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacoesDiagonalInferiorEsquerda(Integer x, Integer y, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();

        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            x--;
            y--;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            for (int xcontador = x; (xcontador >= (x-4) || xcontador >= 0); xcontador-=2){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-1, y-1))){
                    if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-2, y-2))){
                        return posicoesPossiveis;
                    }else {
                        posicoesPossiveis.add(String.format("%s,%s;", xcontador-2, y-2));
                    }
                }else if(xcontador == x){
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador-1, y-1));
                    return posicoesPossiveis;
                }else {
                    return posicoesPossiveis;
                }
                y-=2;
            }
        }
        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacoesDiagonalInferiorDireita(Integer x, Integer y, Integer extremidadeDiagonal, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();

        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            x++;
            y--;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            for (int xcontador = x; (xcontador <= (x+4) || xcontador <= extremidadeDiagonal); xcontador+=2){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+1, y-1))){
                    if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+2, y-2))){
                        return posicoesPossiveis;
                    }else {
                        posicoesPossiveis.add(String.format("%s,%s;", xcontador+2, y-2));
                    }
                }else if (xcontador == x){
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador+1, y-1));
                    return posicoesPossiveis;
                }else {
                    return posicoesPossiveis;
                }
                y-=2;
            }
        }
        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacoesHorizontal(Integer extremidadeHorizontal, Integer x, Integer y, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();
        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            x++;
            if (x<= extremidadeHorizontal) posicoesPossiveis.add(String.format("%s,%s;", x, y));
            x-=2;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            getMovimentacoesHorizontalEsquerda(x, y, posicoesInvalidas, posicoesPossiveis);
            getMovimentacoesHorizontalDireita(extremidadeHorizontal, x, y, posicoesInvalidas, posicoesPossiveis);
        }
        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacoesHorizontalDireita(Integer extremidadeHorizontal, Integer x, Integer y, ArrayList<String> posicoesInvalidas, ArrayList<String> posicoesPossiveis) {
        for (int xcontador = x; (xcontador <= (x +4) || xcontador <= extremidadeHorizontal); xcontador+=2){
            if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+1, y))){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador+2, y))){
                    return posicoesPossiveis;
                }else {
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador+2, y));
                }
            }else if (xcontador == x){
                posicoesPossiveis.add(String.format("%s,%s;", xcontador+1, y));
                return posicoesPossiveis;
            }else {
                return posicoesPossiveis;
            }
        }
        return null;
    }

    private ArrayList<String> getMovimentacoesHorizontalEsquerda(Integer x, Integer y, ArrayList<String> posicoesInvalidas, ArrayList<String> posicoesPossiveis) {
        for (int xcontador = x; (xcontador >= (x -4) || xcontador >= 0); xcontador-=2){
            if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-1, y))){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", xcontador-2, y))){
                    return posicoesPossiveis;
                }else {
                    posicoesPossiveis.add(String.format("%s,%s;", xcontador-2, y));
                }
            }else if (xcontador ==x){
                posicoesPossiveis.add(String.format("%s,%s;", xcontador-1, y));
                return posicoesPossiveis;
            }else {
                return posicoesPossiveis;
            }
        }
        return null;
    }

    private ArrayList<String> getMovimentacoesVertical(Integer x, Integer y, Integer extremidadeVertical, TipoJogadorEnum tipoJogador, ArrayList<String> posicoesInvalidas){
        ArrayList<String> posicoesPossiveis = new ArrayList<>();
        if(TipoJogadorEnum.CACHORRO.equals(tipoJogador)){
            y++;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
            y-=2;
            posicoesPossiveis.add(String.format("%s,%s;", x, y));
        }else {
            getMovimentacaoVerticalInferior(x, y, posicoesInvalidas, posicoesPossiveis);
            getMovimentacaoVerticalSuperior(x, y, extremidadeVertical, posicoesInvalidas, posicoesPossiveis);
        }
        return posicoesPossiveis;
    }

    private ArrayList<String> getMovimentacaoVerticalSuperior(Integer x, Integer y, Integer extremidadeVertical, ArrayList<String> posicoesInvalidas, ArrayList<String> posicoesPossiveis) {
        for (int ycontador = y; (ycontador <= (y +4) || ycontador <= extremidadeVertical); ycontador+=2){
            if(isOcupado(posicoesInvalidas, String.format("%s,%s;", x, ycontador+1))){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", x, ycontador+2))){
                    return posicoesPossiveis;
                }else {
                    posicoesPossiveis.add(String.format("%s,%s;", x, ycontador+2));
                }
            }else if (ycontador == y){
                posicoesPossiveis.add(String.format("%s,%s;", x, ycontador+1));
                return posicoesPossiveis;
            }else {
                return posicoesPossiveis;
            }
        }
        return null;
    }

    private ArrayList<String> getMovimentacaoVerticalInferior(Integer x, Integer y, ArrayList<String> posicoesInvalidas, ArrayList<String> posicoesPossiveis) {
        for (int ycontador = y; (ycontador >= (y -4) || ycontador >= 0); ycontador-=2){
            if(isOcupado(posicoesInvalidas, String.format("%s,%s;", x, ycontador-1))){
                if(isOcupado(posicoesInvalidas, String.format("%s,%s;", x, ycontador-2))){
                    return posicoesPossiveis;
                }else {
                    posicoesPossiveis.add(String.format("%s,%s;", x, ycontador-2));
                }
            }else if (ycontador == y){
                posicoesPossiveis.add(String.format("%s,%s;", x, ycontador-1));
                return posicoesPossiveis;
            }else {
                return posicoesPossiveis;
            }
        }
        return null;
    }

}
