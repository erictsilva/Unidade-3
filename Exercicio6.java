import java.util.*;

public class Exercicio6 {
    static class GrafoBFS {
    private int vertices;  
    private List<Integer>[] listaAdj;  

    public GrafoBFS(int vertices) {
        this.vertices = vertices;
        listaAdj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }
    public void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
        listaAdj[destino].add(origem);  
    }
    public void bfs(int inicio, int destino) {
        boolean[] visitado = new boolean[vertices];  
        int[] anterior = new int[vertices];  
        Queue<Integer> fila = new LinkedList<>();  

        for (int i = 0; i < vertices; i++) {
            visitado[i] = false;
            anterior[i] = -1;
        }

        visitado[inicio] = true;
        fila.add(inicio);

        while (!fila.isEmpty()) {
            int atual = fila.poll();  

            if (atual == destino) {
                break;
            }
            for (int vizinho : listaAdj[atual]) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    anterior[vizinho] = atual;  
                    fila.add(vizinho);
                }
            }
        }
        List<Integer> caminho = reconstruirCaminho(anterior, inicio, destino);

        if (caminho.size() > 0) {
            System.out.println("Caminho mais curto entre " + inicio + " e " + destino + ": " + caminho);
        } else {
            System.out.println("Não há caminho entre " + inicio + " e " + destino);
        }
    }
    private List<Integer> reconstruirCaminho(int[] anterior, int inicio, int destino) {
        List<Integer> caminho = new ArrayList<>();
        for (int i = destino; i != -1; i = anterior[i]) {
            caminho.add(0, i); 
        }
        if (caminho.get(0) == inicio) {
            return caminho;
        } else {
            return new ArrayList<>();  
        }
    }
    public static void main(String[] args) {
  
        GrafoBFS grafo = new GrafoBFS(6);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(3, 5);

        int inicio = 0;
        int destino = 5;

        grafo.bfs(inicio, destino);
    }
}
}

