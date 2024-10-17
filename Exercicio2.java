class TreeNode {
    int valor;
    TreeNode esquerda, direta;

    public TreeNode(int valor) {
        this.valor = valor;
        esquerda = direta = null;
    }
}

public class Exercicio2 {
    public boolean isBST(TreeNode root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.valor <= min || node.valor >= max) {
            return false;
        }
        return isBSTUtil(node.esquerda, min, node.valor) &&
               isBSTUtil(node.direta, node.valor, max);
    }

    public static void main(String[] args) {
        Exercicio2 arvore = new Exercicio2();
        
        TreeNode root = new TreeNode(1);
        root.esquerda = new TreeNode(5);
        root.direta = new TreeNode(2);
        root.esquerda.esquerda = new TreeNode(30);
        root.esquerda.direta = new TreeNode(6);
        root.direta.esquerda = new TreeNode(15);
        root.direta.direta = new TreeNode(25);

        if (arvore.isBST(root)) {
            System.out.println("A árvore é uma BST.");
        } else {
            System.out.println("A árvore NÃO é uma BST.");
        }
    }
}
