class Node:
    value = 0
    nextElement = None

    def __init__(self, value, nextElement):
        self.value = value 
        self.nextElement = nextElement

node = Node(100, None)

print(node.value)