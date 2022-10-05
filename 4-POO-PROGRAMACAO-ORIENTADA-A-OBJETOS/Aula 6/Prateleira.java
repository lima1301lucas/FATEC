import java.util.Scanner;

public class Prateleira{
	public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int array[][] = new int[3][4];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.printf("Digite o valor da prateleira [%d],[%d]:\n>", j, i);
                array[j][i] = input.nextInt();
            }
        }

        for (int i = 0; i <= 3; i++) {
            System.out.printf("______\n");
            for (int j = 0; j <= 2; j++) {
                if (j == 2)
                    System.out.printf("|%2d| \n", array[j][i]);
                else
                    System.out.printf("|%2d|", array[j][i]);
            }
        }
        System.out.printf("______\n");
    }
}