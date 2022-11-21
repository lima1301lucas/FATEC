import java.util.Scanner;

public class vetor {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        double[] vetor = new double[20];
        double media, mediaX, acima, cont = 0;
        media = 0;
        
        for(int i = 0; i < vetor.length; i++){

            System.out.println("Qual a altura?");
            vetor[i] = in.nextDouble();
            media = media + vetor[i];
        }

        in.close();
        
        System.out.println("A altura média foi " + (mediaX = media / vetor.length));
        
        for(int i = 0; i < vetor.length; i++){
            acima = vetor[i];
            if(acima > mediaX){
                cont += 1;
            }
        }

        System.out.println("Existem " + cont + " pessoas acima da média");
    }
}
