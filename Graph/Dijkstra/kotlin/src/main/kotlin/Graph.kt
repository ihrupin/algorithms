class Graph {
    private val relations = mutableMapOf<Int, MutableList<Array<Int>>>()

    fun addVertex(vertex: Int) {
        relations[vertex] = mutableListOf()
    }

    fun addEdge(vertex1: Int, vertex2: Int, weight: Int) {
        relations[vertex1]?.add(arrayOf(vertex2, weight))
    }

    fun printGraph() {
        for (key in relations.keys) {
            relations[key]?.forEach { edge ->
                println(key.toString() + " --> " + edge[0] + " : weight = " + edge[1])
            }
        }
    }

    fun size(): Int {
        return relations.size
    }

    fun getEdges(vertex: Int): List<Array<Int>>? {
        return relations[vertex]
    }
}