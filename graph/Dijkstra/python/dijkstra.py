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

def getItemWithSmallestValue(dictionaty):
    smallest = -1
    smallestKey = -1
    for v in dictionaty:
        current = dictionaty[v]
        if smallest < 0 or smallest > current:
            smallest = current
            smallestKey = v
    return [smallestKey, smallest]


def getShortestDistances(fromVertex, graph):
    shortestDistanceResult = {}
    resolvedVertexDict = {}

    basedVertex = fromVertex
    resolvedVertexDict[fromVertex] = 0

    while len(graph) > len(resolvedVertexDict):
        basedVertexRelations = graph[basedVertex]
        for edge in basedVertexRelations:
            vertex = edge[0]
            weight = edge[1]

            newDistance = resolvedVertexDict[basedVertex] + weight

            if vertex not in shortestDistanceResult or shortestDistanceResult[vertex] > newDistance:
                shortestDistanceResult[vertex] = newDistance

        smallestItem = getItemWithSmallestValue(shortestDistanceResult)
        smallestVertexName = smallestItem[0]
        smallestDistance = smallestItem[1]

        del shortestDistanceResult[smallestVertexName]
        resolvedVertexDict[smallestVertexName] = smallestDistance
        basedVertex = smallestVertexName

    return resolvedVertexDict



graph = initGraph()
graphMethods.printGraph(graph)

#Task: Find shortest distance from vertex 1 to rest of vertexes

shortestDistances = getShortestDistances(1, graph)

print("Shortest distances from vertex 1 to others are:")
print(shortestDistances)

    

        
        
        

