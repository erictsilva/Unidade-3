import java.util.LinkedList;
import java.util.List;

public class Exercicio5 {
    
    static class GrafoListaAdj {
    private int vertices; 
    private List<Integer>[] listaAdj;  

    public GrafoListaAdj(int vertices) {
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
    public void mostrarGrafo() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vértice " + i + ":");
            for (Integer adj : listaAdj[i]) {
                System.out.print(" -> " + adj);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
  
        GrafoListaAdj grafo = new GrafoListaAdj(5);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 4);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);

        grafo.mostrarGrafo();
    }
}
}
