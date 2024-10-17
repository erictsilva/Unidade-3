import java.util.*;

class Grafo {
    private int numVertices; 
    private LinkedList<Adjacente>[] adjList; 

    class Adjacente {
        int vertice;
        int peso;
        public Adjacente(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addAresta(int u, int v, int peso) {
        adjList[u].add(new Adjacente(v, peso));
        adjList[v].add(new Adjacente(u, peso)); 
    }
    public void dijkstra(int origem, int destino) {
        int[] dist = new int[numVertices]; 
        int[] anterior = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        Arrays.fill(anterior, -1); 

        PriorityQueue<Adjacente> filaPrioridade = new PriorityQueue<>(numVertices, Comparator.comparingInt(a -> a.peso));

        dist[origem] = 0;
        filaPrioridade.add(new Adjacente(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            Adjacente atual = filaPrioridade.poll();
            int u = atual.vertice;

            if (u == destino) {
                break;
            }
            for (Adjacente vizinho : adjList[u]) {
                int v = vizinho.vertice;
                int pesoAresta = vizinho.peso;

                if (dist[u] + pesoAresta < dist[v]) {
                    dist[v] = dist[u] + pesoAresta;
                    anterior[v] = u; 
                    filaPrioridade.add(new Adjacente(v, dist[v]));
                }
            }
        }
        exibirCaminho(origem, destino, anterior, dist);
    }
    private void exibirCaminho(int origem, int destino, int[] anterior, int[] dist) {
        if (dist[destino] == Integer.MAX_VALUE) {
            System.out.println("Não há caminho entre " + origem + " e " + destino);
            return;
        }

        LinkedList<Integer> caminho = new LinkedList<>();
        for (int v = destino; v != -1; v = anterior[v]) {
            caminho.addFirst(v);
        }

        System.out.println("Caminho mais curto de " + origem + " até " + destino + ": " + caminho);
        System.out.println("Distância total: " + dist[destino]);
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(6); 

        grafo.addAresta(0, 1, 4);
        grafo.addAresta(0, 2, 2);
        grafo.addAresta(1, 2, 1);
        grafo.addAresta(1, 3, 5);
        grafo.addAresta(2, 3, 8);
        grafo.addAresta(2, 4, 10);
        grafo.addAresta(3, 4, 2);
        grafo.addAresta(3, 5, 6);
        grafo.addAresta(4, 5, 3);

        int origem = 0;  
        int destino = 5; 

        System.out.println("Encontrando o caminho mais curto: ");
        grafo.dijkstra(origem, destino); 
    }
}
