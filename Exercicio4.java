public class Exercicio4 {
    public static int binarySearch(int[] array, int posicao) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int mid = esquerda + (direita - esquerda) / 2; 
            if (array[mid] == posicao) {
                return mid;
            }
            if (array[mid] < posicao) {
                esquerda = mid + 1;
            }else {
                direita = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}; 
        int posicao = 7;
        
        int resultado = binarySearch(array, posicao);
        
        if (resultado != -1) {
            System.out.println("\nO número " + posicao + " foi encontrado na posição: " + resultado);
        } else {
            System.out.println("\nO Número " + posicao + " não foi encontrado.");
        }
    }
}
