import java.util.LinkedList;
import java.util.List;

public class Exercicio5 {
    private int numVertices; 
    private List<List<Integer>> listaAdj; 

    public Exercicio5(int numVertices) {
        this.numVertices = numVertices;
        listaAdj = new LinkedList<>(); 

        for (int i = 0; i < numVertices; i++) {
            listaAdj.add(new LinkedList<>());
        }
    }
    public void adicionarAresta(int origem, int destino) {
        listaAdj.get(origem).add(destino); 
        listaAdj.get(destino).add(origem); 
    }
    public void mostrarGrafo() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ":");
            for (Integer adj : listaAdj.get(i)) {
                System.out.print(" -> " + adj);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Exercicio5 grafo = new Exercicio5(5);
        
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
