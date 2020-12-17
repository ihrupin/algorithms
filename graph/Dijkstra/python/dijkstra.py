import graphMethods

def initGraph():
    graph = {}

    graphMethods.addVertexToDictionary(graph, 1)
    graphMethods.addVertexToDictionary(graph, 2)
    graphMethods.addVertexToDictionary(graph, 3)
    graphMethods.addVertexToDictionary(graph, 4)
    graphMethods.addVertexToDictionary(graph, 5)
    graphMethods.addVertexToDictionary(graph, 6)

    graphMethods.addEdge(graph, 1, 2, 6)
    graphMethods.addEdge(graph, 1, 3, 4)

    graphMethods.addEdge(graph, 2, 4, 7)
    graphMethods.addEdge(graph, 2, 5, 4)
    graphMethods.addEdge(graph, 2, 6, 2)

    graphMethods.addEdge(graph, 3, 4, 3)
    graphMethods.addEdge(graph, 3, 5, 8)

    graphMethods.addEdge(graph, 4, 6, 10)

    graphMethods.addEdge(graph, 5, 6, 1)

    return graph

graph = initGraph()
graphMethods.printGraph(graph)