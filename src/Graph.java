import java.util.LinkedList;
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
    public void addEdge(int start, int end) {
        Link n1 = new Link(end, edges[start]);
        edges[start] = n1;
        Link n2 = new Link(start, edges[end]);
        edges[end] = n2;
    }

    /**
     * Vrati delku nejkratsi cesty mezi vrcholy start a end
     * @param start pocatecni vrchol
     * @param end koncovy vrchol
     * @return delka nejkratsi cesty
     */
    public int shortestPathLength(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] states = new int[edges.length];
        int[] distances = new int[edges.length];

        q.add(start);

        while(!q.isEmpty()) {
            int current = q.poll();
            Link l = edges[current];

            while(l != null) {
                if(states[l.neighbour] == 0) {
                    states[l.neighbour] = 1;
                    distances[l.neighbour] = distances[current] + 1;

                    q.add(l.neighbour);
                }

                l = l.next;
            }

            states[current] = 2;
        }

        return distances[end];
    }
}