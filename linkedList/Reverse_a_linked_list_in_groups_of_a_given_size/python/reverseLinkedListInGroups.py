class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
 
    def reverse(self, head, k):
        current = head  
        next  = None
        prev = None
        count = 0 
          
        while(current is not None and count < k): 
            next = current.next
            current.next = prev 
            prev = current 
            current = next 
            count += 1
  
        if next is not None: 
            head.next = self.reverse(next, k) 
  
        return prev
 
    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node
 
    def printList(self):
        temp = self.head
        stringBuffer = ""
        while(temp):
            stringBuffer += str(temp.data)
            temp = temp.next
            if (temp):
                stringBuffer += "--->"
            else:
                stringBuffer += "--->NULL"
        print(stringBuffer)


llist = LinkedList()
llist.push(12)
llist.push(23)
llist.push(53)
llist.push(90)
llist.push(12)
llist.push(56)
llist.push(13)
llist.push(8)
llist.push(5)
 
print("Given Linked List")
llist.printList()
llist.head = llist.reverse(llist.head, 3)
print("Reversed Linked List")
llist.printList()