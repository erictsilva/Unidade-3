import java.util.*;

public class Exercicio10{    

static class Grafo {
    private int vertices;  
    private List<List<Integer>> listaAdj;  

    public Grafo(int vertices) {
        this.vertices = vertices;
        listaAdj = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            listaAdj.add(new ArrayList<>());
        }
    }
    public void adicionarAresta(int origem, int destino) {
        listaAdj.get(origem).add(destino);
    }
    private void ordenarTopologicoDFS(int vertice, boolean[] visitado, Stack<Integer> pilha) {
        visitado[vertice] = true;

        for (Integer vizinho : listaAdj.get(vertice)) {
            if (!visitado[vizinho]) {
                ordenarTopologicoDFS(vizinho, visitado, pilha);
            }
        }
        pilha.push(vertice);
    }

    public void ordenacaoTopologica() {
        Stack<Integer> pilha = new Stack<>();

        boolean[] visitado = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visitado[i]) {
                ordenarTopologicoDFS(i, visitado, pilha);
            }
        }

        System.out.println("Ordenação Topológica:");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.adicionarAresta(5, 2);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(4, 1);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);

        grafo.ordenacaoTopologica();
    }
}

}
