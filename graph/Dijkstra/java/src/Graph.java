import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Integer, List<Integer[]>> relations = new HashMap<>();

    public void addVertex(int vertex) {
        relations.put(vertex, new ArrayList<>());
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        List<Integer[]> edges = relations.get(vertex1);
        edges.add(new Integer[]{vertex2, weight});
        relations.put(vertex1, edges);
    }

    public void printGraph() {
        for (int key : relations.keySet()) {
            List<Integer[]> edges = relations.get(key);
            for (Integer[] edge: edges) {
                System.out.println(key + " --> " + edge[0] + " : weight = " + edge[1]);
            }
        }
    }

    public int size() {
        return relations.size();
    }

    public List<Integer[]> getEdges(int vertex) {
        return relations.get(vertex);
    }
}
