import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Graph graph = initGraph();
        graph.printGraph();

        System.out.println("Shortest distances from vertex 1 to others are:");
        Map<Integer, Integer> result = dijkstra(1, graph);
        System.out.println(result);
    }

    private static Map<Integer, Integer> dijkstra(int fromVertex, Graph graph) {
        Map<Integer, Integer> shortestDistanceResult = new HashMap<>();
        Map<Integer, Integer> resolvedVertexDict = new HashMap<>();

        int basedVertex = fromVertex;
        resolvedVertexDict.put(basedVertex, 0);

        while (graph.size() > resolvedVertexDict.size()) {
            List<Integer[]> basedVertexRelations = graph.getEdges(basedVertex);
            for (Integer[] edge : basedVertexRelations) {
                int vertex = edge[0];
                int weight = edge[1];

                int newDistance = resolvedVertexDict.get(basedVertex) + weight;
                if (shortestDistanceResult.get(vertex) == null || shortestDistanceResult.get(vertex) > newDistance) {
                    shortestDistanceResult.put(vertex, newDistance);
                }
            }

            Integer[] smallestItem = getItemWithSmallestValue(shortestDistanceResult);
            int smallestVertexName = smallestItem[0];
            int smallestDistance = smallestItem[1];

            shortestDistanceResult.remove(smallestVertexName);
            resolvedVertexDict.put(smallestVertexName, smallestDistance);
            basedVertex = smallestVertexName;
        }
        return resolvedVertexDict;
    }

    private static Integer[] getItemWithSmallestValue(Map<Integer, Integer> map) {
        int smallest = -1;
        int smallestKey = -1;
        for(Integer key : map.keySet()) {
            int current = map.get(key);
            if (smallest < 0 || smallest > current) {
                smallest = current;
                smallestKey = key;
            }
        }
        return new Integer[]{smallestKey, smallest};
    }

    private static Graph initGraph() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 4);

        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 6, 2);

        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 8);

        graph.addEdge(4, 6, 10);

        graph.addEdge(5, 6, 1);
        return graph;
    }
}
