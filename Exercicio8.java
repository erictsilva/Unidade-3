public class Exercicio8{
class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        this.valor = item;
        esquerda = direita = null;
    }
}
private No raiz;

public Exercicio8(){
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
        if (valor < raiz.valor){
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        }else if (valor > raiz.valor){
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }
        return raiz;            
    }

    public int encontrarMenorValor() {
        return encontrarMenorValorRecursivo(raiz);
    }

    private int encontrarMenorValorRecursivo(No raiz) {

        if (raiz.esquerda == null){
            return raiz.valor;
        }else {
            return encontrarMenorValorRecursivo(raiz.esquerda);
        }    
    }
    public static void main(String[] args) {
        Exercicio8 arvore = new Exercicio8();

        arvore.inserir(22);
        arvore.inserir(15);
        arvore.inserir(32);
        arvore.inserir(18);
        arvore.inserir(12);
        arvore.inserir(26);

        int menorValor = arvore.encontrarMenorValor();
        System.out.println("O menor valor na árvore binária de busca é: " + menorValor);
    }
}    


