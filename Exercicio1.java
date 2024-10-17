class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}
class ArvoreBinaria {
    No raiz;

    // Construtor para inicializar a árvore vazia
    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }
        return raiz;
    }

    // Percurso em ordem (in-order traversal)
    public void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    private void emOrdemRecursivo(No raiz) {
        if (raiz != null) {
            emOrdemRecursivo(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdemRecursivo(raiz.direita);
        }
    }

    public void preOrdem() {
        preOrdemRecursivo(raiz);
    }

    private void preOrdemRecursivo(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRecursivo(raiz.esquerda);
            preOrdemRecursivo(raiz.direita);
        }
    }

    public void posOrdem() {
        posOrdemRecursivo(raiz);
    }

    private void posOrdemRecursivo(No raiz) {
        if (raiz != null) {
            posOrdemRecursivo(raiz.esquerda);
            posOrdemRecursivo(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Percurso em Ordem:");
        arvore.emOrdem();
        System.out.println();

        System.out.println("Percurso em Pré-Ordem:");
        arvore.preOrdem();
        System.out.println();

        System.out.println("Percurso em Pós-Ordem:");
        arvore.posOrdem();
        System.out.println();
    }
}
