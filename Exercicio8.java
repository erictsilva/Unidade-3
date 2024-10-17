public class Exercicio8{

    static class No {
    int valor;
    No esquerda, direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

static class ArvoreBinariaDeBusca {
    No raiz;

    public ArvoreBinariaDeBusca() {
        raiz = null;
    }
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }
    private No adicionarRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, valor);
        }

        return atual;
    }
    public int encontrarMenorValor() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        return encontrarMenorValorRecursivo(raiz);
    }
    private int encontrarMenorValorRecursivo(No atual) {
        if (atual.esquerda == null) {
            return atual.valor;
        } else {
            return encontrarMenorValorRecursivo(atual.esquerda);
        }
    }

    public static void main(String[] args) {
     
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        arvore.adicionar(52);
        arvore.adicionar(15);
        arvore.adicionar(20);
        arvore.adicionar(10);
        arvore.adicionar(65);
        arvore.adicionar(35);
        arvore.adicionar(22);

        System.out.println("O menor valor na árvore é: " + arvore.encontrarMenorValor());
    }
}

}    
