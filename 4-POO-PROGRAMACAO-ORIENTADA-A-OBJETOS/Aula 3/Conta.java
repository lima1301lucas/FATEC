import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        String numConta;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número da conta");
        numConta = input.next();
        input.close();

        int soma1 = Integer.parseInt(numConta.toString().substring(0,1)) + Integer.parseInt(numConta.toString().substring(1,2)) + Integer.parseInt(numConta.toString().substring(2,3)) + Integer.parseInt(numConta.toString().substring(3,4));

        int numDigito = soma1 % 10;
                
        System.out.println("Seu número de conta é: 00" + numConta + "-" + numDigito); 
    }
}
