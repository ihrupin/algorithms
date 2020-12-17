def addVertexToDictionary(vertex):
  global graph
  global graphVerticesCount
  if vertex in graph:
    print("Vertex ", vertex, " already exists.")
  else:
    graphVerticesCount += 1
    graph[vertex] = []

def addEdge(vertex1, vertex2, edgeEeight):
  global graph
  if vertex1 not in graph:
    print("Vertex ", vertex1, " does not exist.")
  elif vertex2 not in graph:
    print("Vertex ", vertex2, " does not exist.")
  else:
    # Since this code is not restricted to a directed or 
    # an undirected graph, an edge between vertex1 vertex2 does not
    # imply that an edge exists between vertex2 and vertex1
    temp = [vertex2, edgeEeight]
    graph[vertex1].append(temp)

def printGraph():
  global graph
  for vertex in graph:
    for edges in graph[vertex]:
      print(vertex, " -> ", edges[0], " edge weight: ", edges[1])

graph = {}
graphVerticesCount = 0

def initGraph():
    addVertexToDictionary(1)
    addVertexToDictionary(2)
    addVertexToDictionary(3)
    addVertexToDictionary(4)
    addVertexToDictionary(5)
    addVertexToDictionary(6)

    addEdge(1, 2, 6)
    addEdge(1, 3, 4)

    addEdge(2, 4, 7)
    addEdge(2, 5, 4)
    addEdge(2, 6, 2)

    addEdge(3, 4, 3)
    addEdge(3, 5, 8)

    addEdge(4, 6, 10)

    addEdge(5, 6, 1)
