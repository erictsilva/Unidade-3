class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class Exercicio1 {
    No root;
    public Exercicio1() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private No insertRec(No root, int value) {
        if (root == null) {
            root = new No(value);
            return root;
        }
        if (value < root.valor) {
            root.esquerda = insertRec(root.esquerda, value);
        } else if (value > root.valor) {
            root.direita = insertRec(root.direita, value);
        }

        return root;
    }

    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println(); 
    }
    private void preOrderRec(No root) {
        if (root != null) {
            System.out.print(root.valor + " ");
            preOrderRec(root.esquerda);
            preOrderRec(root.direita);
        }
    }
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println(); 
    }
    private void inOrderRec(No root) {
        if (root != null) {
            inOrderRec(root.esquerda);
            System.out.print(root.valor + " ");
            inOrderRec(root.direita);
        }
    }
    public void postOrderTraversal() {
        postOrderRec(root);
        System.out.println(); 
    }
    private void postOrderRec(No root) {
        if (root != null) {
            postOrderRec(root.esquerda);
            postOrderRec(root.direita);
            System.out.print(root.valor + " ");
        }
    }
    public static void main(String[] args) {
        Exercicio1 arvore = new Exercicio1();

        arvore.insert(15);
        arvore.insert(25);
        arvore.insert(12);
        arvore.insert(30);
        arvore.insert(32);
        arvore.insert(57);
        arvore.insert(62);

        System.out.println("Percurso Pré-Ordem:");
        arvore.preOrderTraversal();

        System.out.println("Percurso Em-Ordem:");
        arvore.inOrderTraversal();

        System.out.println("Percurso Pós-Ordem:");
        arvore.postOrderTraversal();
    }
}
