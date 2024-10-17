import java.util.*;

public class Exercicio6 {
    public static List<Integer> encontrarCaminhoMaisCurto(Map<Integer, List<Integer>> grafo, int inicio, int fim) {
        Queue<Integer> fila = new LinkedList<>();
        Map<Integer, Integer> predecessores = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();

        fila.add(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            if (atual == fim) {
                return construirCaminho(predecessores, inicio, fim);
            }

            for (int vizinho : grafo.getOrDefault(atual, Collections.emptyList())) {
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                    predecessores.put(vizinho, atual);
                }
            }
        }
        return Collections.emptyList(); // Caminho não encontrado
    }

    private static List<Integer> construirCaminho(Map<Integer, Integer> predecessores, int inicio, int fim) {
        List<Integer> caminho = new ArrayList<>();
        for (int atual = fim; atual != inicio; atual = predecessores.get(atual)) {
            caminho.add(atual);
        }
        caminho.add(inicio);
        Collections.reverse(caminho);
        return caminho;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> grafo = new HashMap<>();
        grafo.put(1, Arrays.asList(2, 3));
        grafo.put(2, Arrays.asList(4));
        grafo.put(3, Arrays.asList(4, 5));
        grafo.put(4, Arrays.asList(5));
        grafo.put(5, Arrays.asList());

        int inicio = 1;
        int fim = 5;
        List<Integer> caminho = encontrarCaminhoMaisCurto(grafo, inicio, fim);

        if (!caminho.isEmpty()) {
            System.out.println("Caminho mais curto: " + caminho);
        } else {
            System.out.println("Não foi encontrado um caminho.");
        }
    }
}
