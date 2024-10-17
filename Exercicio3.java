public class Exercicio3 {
    public static int search(int[] array, int posicao) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == posicao) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {19, 21, 65, 20, 1, 78};
        int posicao = 12;
        
        int resultado = search(array, posicao);
        
        if (resultado != -1) {
            System.out.println("O número " + posicao + " foi encontrado na posição: " + resultado);
        } else {
            System.out.println("O número " + posicao + " não encontrado.");
        }
    }
}
