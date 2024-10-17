import java.util.Scanner;

public class Exercicio4 {

    public static int buscaBinaria(int[] array, int numeroProcurado) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; 

            if (array[meio] == numeroProcurado) {
                return meio;  
            }

            if (array[meio] < numeroProcurado) {
                inicio = meio + 1;
            }else {
                fim = meio - 1;
            }
        }

        return -1; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int posicao;

        do {
            System.out.println("Digite o número que deseja procurar: ");
        int numeroProcurado = scanner.nextInt();

        posicao = buscaBinaria(array, numeroProcurado);

        if (posicao != -1) {
            System.out.println("Número ' " + numeroProcurado + " ' encontrado na posição: " + posicao);
        } else {
            System.out.println("Número ' " + numeroProcurado + " ' não encontrado. Tente novamente.");
        }
        }while (posicao == -1);       

        scanner.close();
    }
}
