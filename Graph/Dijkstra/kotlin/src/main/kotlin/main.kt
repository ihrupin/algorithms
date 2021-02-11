fun main() {
    val graph: Graph = initGraph()
    graph.printGraph()

    println("Shortest distances from vertex 1 to others are:")

    val result: Map<Int, Int> = dijkstra(1, graph)
    println(result)
}

private fun dijkstra(fromVertex: Int, graph: Graph): Map<Int, Int> {
    val shortestDistanceResult: MutableMap<Int, Int> = HashMap()
    val resolvedVertexDict: MutableMap<Int, Int> = HashMap()

    var basedVertex = fromVertex
    resolvedVertexDict[basedVertex] = 0

    while (graph.size() > resolvedVertexDict.size) {
        val basedVertexRelations = graph.getEdges(basedVertex)

        basedVertexRelations?.forEach { edge ->
            val vertex = edge[0]
            val weight = edge[1]
            resolvedVertexDict[basedVertex]?.plus(weight)?.let { newDistance ->
                if (shortestDistanceResult[vertex] == null || shortestDistanceResult[vertex]!! > newDistance) {
                    shortestDistanceResult[vertex] = newDistance
                }
            }
        }
        val smallestItem = getItemWithSmallestValue(shortestDistanceResult)
        val smallestVertexName = smallestItem[0]
        val smallestDistance = smallestItem[1]

        shortestDistanceResult.remove(smallestVertexName)
        resolvedVertexDict[smallestVertexName] = smallestDistance

        basedVertex = smallestVertexName
    }
    return resolvedVertexDict
}

private fun getItemWithSmallestValue(map: Map<Int, Int>): Array<Int> {
    var smallest = -1
    var smallestKey = -1
    map.keys.forEach { key ->
        map[key]?.let { current ->
            if (smallest < 0 || smallest > current) {
                smallest = current
                smallestKey = key
            }
        }
    }
    return arrayOf(smallestKey, smallest)
}

private fun initGraph(): Graph {
    val graph = Graph()
    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    graph.addVertex(4)
    graph.addVertex(5)
    graph.addVertex(6)
    graph.addEdge(1, 2, 6)
    graph.addEdge(1, 3, 4)
    graph.addEdge(2, 4, 7)
    graph.addEdge(2, 5, 4)
    graph.addEdge(2, 6, 2)
    graph.addEdge(3, 4, 3)
    graph.addEdge(3, 5, 8)
    graph.addEdge(4, 6, 10)
    graph.addEdge(5, 6, 1)
    return graph
}
