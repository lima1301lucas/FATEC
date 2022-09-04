import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        float valor, valorTotal, vlrFinal;
        valor = 0;
        valorTotal= 0;

        do{
            Scanner input = new Scanner(System.in);
            System.out.println("Digite o valor do item: ");
            valor = input.nextFloat();
            valorTotal = valorTotal + valor;
        }
        while(valor != 0);

        if(valorTotal < 50){
            vlrFinal = valorTotal * 0.95f;
        }
        else{
            if(valorTotal <=  100){
                vlrFinal = valorTotal * 0.90f;
            }
            else{
                if(valorTotal <= 200){
                    vlrFinal = valorTotal * 0.85f;
                }
                else{
                    vlrFinal = valorTotal * 0.80f;
                }
            }
        }
        System.out.print("\nValor total da compra: R$ " + valorTotal);
        System.out.print("\nValor total com desconto: R$ " + vlrFinal);
    }  
}
