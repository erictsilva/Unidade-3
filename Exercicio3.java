import java.util.Scanner;

public class Exercicio3 {

    public static int buscaLinear(int[] array, int numeroProcurado) {
       
        for (int i = 0; i < array.length; i++) {
          
            if (array[i] == numeroProcurado) {
                return i;  
            }
        }
        return -1;  
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {10, 23, 45, 78, 92, 100, 56, 38 , 45, 94, 85, 21, 36};
        int posicao;

        do {
        
            System.out.println("Digite o número que deseja procurar: ");
            int numeroProcurado = scanner.nextInt();

            posicao = buscaLinear(array, numeroProcurado);

            if (posicao != -1) {
                System.out.print("Número ' " + numeroProcurado + " ' encontrado na posição: " + posicao);
            } else {
                System.out.println("Número ' " + numeroProcurado + " ' não encontrado. Tente novamente.");
            }
        } while (posicao == -1);  

        scanner.close();
    }
}
