import java.util.Scanner;

public class Geral {
    public static void main(String agrs[]) {

        Scanner input = new Scanner(System.in);
        String[][] vetFuncionarios = new String[5][6];

        Funcionario func = new Funcionario(null, null);
        Programador prog = new Programador(null, null, null);
        Instrutor inst = new Instrutor(null, null, null);

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.print("\n------------------------INFORMAÇÕES-------------------");
                System.out.printf("\nQual o nome do Funcionário? ");
                vetFuncionarios[j][0] = input.next();
                func.setNome(vetFuncionarios[j][0]);

                System.out.printf("Qual o email? ");
                vetFuncionarios[j][1] = input.next();
                func.setEmail(vetFuncionarios[j][1]);

                System.out.printf("Qual a idade? ");
                vetFuncionarios[j][2] = input.next();
                func.setIdade(Integer.parseInt(vetFuncionarios[j][2]));

                System.out.printf("Qual a linguagem de programação? ");
                vetFuncionarios[j][3] = input.next();
                prog.setLinguagem(vetFuncionarios[j][3]);

                System.out.printf("Qual o sistema operacional? ");
                vetFuncionarios[j][4] = input.next();
                prog.setSistOper(vetFuncionarios[j][4]);

                System.out.printf("Qual é a disciplina? ");
                vetFuncionarios[j][5] = input.next();
                inst.setDisciplina(vetFuncionarios[j][5]);

               func.exibeDados();
               prog.exibeDados();
               inst.exibeDados();
            }
        }
        input.close();
    }
}
