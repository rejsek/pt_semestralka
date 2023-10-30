import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Graf pro ulozeni mapy
 */
class Graph {
    /** Sousedi jednotlivych vrcholu (hrany) */
    Link[] edges;

    /**
     * Inicializuje sousedy jednotlivych vrcholu (hrany)
     * @param vertexCount pocet vrcholu grafu
     */
    public void initialize(int vertexCount) {
        edges = new Link[vertexCount];
    }

    /**
     * Prida do grafu novou obousmernou hranu
     * @param start cislo pocatecniho vrcholu
     * @param end cislo koncoveho vrcholu
     */
    public void addEdge(IGraph start, IGraph end, double edgeWeight) {
        int idStart = start.getId() - 1;
        int idEnd = end.getId() - 1;

        Link n1 = new Link(end, edges[idStart], edgeWeight);
        edges[idStart] = n1;
        Link n2 = new Link(start, edges[idEnd], edgeWeight);
        edges[idEnd] = n2;
    }

    public double shortestPathLengthE(IGraph start, IGraph end) {
        int vertexCount = edges.length;
        double[] distances = new double[vertexCount];
        Arrays.fill(distances, Double.MAX_VALUE);
        int startId = start.getId() - 1;
        int endId = end.getId() - 1;
        distances[startId] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Double.compare( distances[v1],  distances[v2]));
        pq.add(startId);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            Link l = edges[current];

            while (l != null) {
                double newDistance = distances[current] + l.edgeWeight;

                if (newDistance < distances[l.neighbour.getId() - 1]) {
                    distances[l.neighbour.getId() - 1] = newDistance;
                    pq.add(l.neighbour.getId() - 1);
                }

                l = l.next;
            }
        }

        return distances[endId];
    }


    /**
     * Vrati delku nejkratsi cesty mezi vrcholy start a end
     * @param start pocatecni vrchol
     * @param end koncovy vrchol
     * @return delka nejkratsi cesty
     */
    public int shortestPathLength(IGraph start, IGraph end) {
        int vertexCount = edges.length;
        int[] distances = new int[vertexCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int startId = start.getId() - 1;
        int endId = end.getId() - 1;
        distances[startId] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(distances[v1], distances[v2]));
        pq.add(startId);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            Link l = edges[current];

            while (l != null) {
                int newDistance = distances[current] + 1;

                if (newDistance < distances[l.neighbour.getId() - 1]) {
                    distances[l.neighbour.getId() - 1] = newDistance;
                    pq.add(l.neighbour.getId() - 1);
                }

                l = l.next;
            }
        }

        return distances[endId];
    }

    public Link[] getEdges(){
        /**
         * Vrati hrany grafu
         */

        return edges;
    }
}