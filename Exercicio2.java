public class Exercicio2 {
    static class No {
    int valor;
    No esquerda, direita;

        public No(int valor) {
            this.valor = valor;
            esquerda = direita = null;
        }
    }
    private No raiz;

    public boolean verificaBST() {
        return eBSTUtil(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean eBSTUtil(No no, int valorMinimo, int valorMaximo) {
        if (no == null) {
            return true;
        }

        if (no.valor < valorMinimo || no.valor > valorMaximo) {
            return false;
        }

        return (eBSTUtil(no.esquerda, valorMinimo, no.valor - 1) &&
                eBSTUtil(no.direita, no.valor + 1, valorMaximo));
    }

    public static void main(String[] args) {
        Exercicio2 arvore = new Exercicio2();

        boolean ehBST = arvore.verificaBST();

        arvore.raiz = new No(3);
        arvore.raiz.esquerda = new No(5);
        arvore.raiz.direita = new No(2);
        arvore.raiz.esquerda.esquerda = new No(7);
        arvore.raiz.esquerda.direita = new No(1);

        if (ehBST) {
            System.out.println("A árvore é uma Árvore Binária de Busca (BST).");
        } else {
            System.out.println("A árvore não é uma Árvore Binária de Busca (BST).");
        }
    }
}
