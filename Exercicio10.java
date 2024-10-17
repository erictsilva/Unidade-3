import java.util.*;

class Grafo {
    private int numVertices; 
    private LinkedList<Integer>[] adjList; 

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addAresta(int v, int w) {
        adjList[v].add(w); 
    }
    public void ordenacaoTopologica() {
        int[] grauEntrada = new int[numVertices]; 
        LinkedList<Integer> ordenacao = new LinkedList<>(); 
        Queue<Integer> fila = new LinkedList<>(); 

        for (int i = 0; i < numVertices; i++) {
            for (int adj : adjList[i]) {
                grauEntrada[adj]++;
            }
        }
        for (int i = 0; i < numVertices; i++) {
            if (grauEntrada[i] == 0) {
                fila.add(i);
            }
        }
        while (!fila.isEmpty()) {
            int v = fila.poll(); 
            ordenacao.add(v);    
            for (int adj : adjList[v]) {
                grauEntrada[adj]--;
                if (grauEntrada[adj] == 0) {
                    fila.add(adj);
                }
            }
        }
        if (ordenacao.size() != numVertices) {
            System.out.println("O grafo contém um ciclo, então não é possível realizar a ordenação topológica.");
        } else {
            System.out.println("Ordenação Topológica dos vértices:");
            for (int v : ordenacao) {
                System.out.print(v + " ");
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.addAresta(5, 2);
        grafo.addAresta(5, 0);
        grafo.addAresta(4, 0);
        grafo.addAresta(4, 1);
        grafo.addAresta(2, 3);
        grafo.addAresta(3, 1);

        System.out.println("A ordenação topológica é:");
        grafo.ordenacaoTopologica();
    }
}
