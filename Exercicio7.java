import java.util.*;

public class Exercicio7 {
static class Grafo {
    private int numVertices; 
    private LinkedList<Integer> adjList[]; 

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

    private void DFSUtil(int v, boolean visitados[]) {
        visitados[v] = true;
        System.out.print(v + " ");

        for (int adj : adjList[v]) {
            if (!visitados[adj]) {
                DFSUtil(adj, visitados);
            }
        }
    }
    public void DFS(int v) {
        boolean visitados[] = new boolean[numVertices];
        DFSUtil(v, visitados);
    }

    public static void main(String args[]) {
        Grafo grafo = new Grafo(6); 

        grafo.addAresta(0, 1);
        grafo.addAresta(0, 2);
        grafo.addAresta(1, 3);
        grafo.addAresta(1, 4);
        grafo.addAresta(2, 5);

        System.out.println("Vértices visitados pela DFS:");

        grafo.DFS(0);
    }
}    
}
