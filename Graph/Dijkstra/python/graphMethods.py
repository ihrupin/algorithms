def addVertexToDictionary(graph, vertex):
  if vertex in graph:
    print("Vertex ", vertex, " already exists.")
  else:
    graph[vertex] = []

def addEdge(graph, vertex1, vertex2, edgeEeight):
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

def printGraph(graph):
  for vertex in graph:
    for edges in graph[vertex]:
      print(vertex, " -> ", edges[0], " edge weight: ", edges[1])
