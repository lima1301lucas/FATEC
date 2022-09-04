import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {

        int quantidade, num;
        float salario, totalSalario, salarioMaior, salarioMenor;

        totalSalario = 0;
        salarioMenor = 1;
        salarioMaior = 1;

        Scanner input = new Scanner(System.in);

        do{
            System.out.print("\nQuantos funcionários têm a empresa? ");
            quantidade = input.nextInt();

            if(quantidade == 0) System.out.print("Erro. Digite o número novamente ");
        }
        while (quantidade <= 0);
        
        for(num = 1; num <= quantidade; num++){
            System.out.print(num + "° salário: ");
            salario = input.nextFloat();

            totalSalario = totalSalario + salario;
            salarioMenor = salario;
            
            if (salarioMenor >  salario){
                salarioMenor = salario;
            }
            if (salarioMaior < salario){
                salarioMaior = salario;
            }
        }
        System.out.println("Salário médio R$" + totalSalario/quantidade);
        System.out.println("Menor salário R$" + salarioMenor);
        System.out.println("Maior salário R$" + salarioMaior);
    }   
}
