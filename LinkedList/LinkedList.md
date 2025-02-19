# Linked List
---
### Linked lists are a linear collection of data elements or nodes where it points to other data elements. This data structure allows efficient insertion and deletion and is the basis to other data structures like Stacks and Queues.
---

## Types of linked lists
- ### Singly Linked Lists
    Singly linked lists is a type of linked list that has their nodes point next to a single node

    Example:
  
    1|2 -> 2|3 -> 3|4 -> 4|Null
- ### Doubly Linked Lists
    Doubly linked lists has their nodes point next to another node and another pointer pointing to a previous node

  Example:
  
     Null|1|2 <->1|2| 3 <-> 2|3|4 <-> 3|4|Null
- ### Circular Linked Lists
    Circular Linked Lists has the ending node point back to the starting node, creating a loop

  Example:
  
    1|2 -> 2|3 -> 3|4 -> 4|1

## Features
- ### Singly Linked Lists
    - traversal()
    - search()
    - length()
    - insertAtStart()
    - insertAtEnd()
    - insertAtPos
    - deleteStart()
    - deleteEnd()
    - deletePos()
- ### Doubly Linked Lists
    - forwTraversal()
    - backTraversal()
    - length()
    - insertStart()
    - insertEnd()
    - insertPos()
    - deleteStart()
    - deleteEnd()
    - deletePos()
- ### Circular Linked Lists
    - insertEmpty()
    - insertStart()
    - insertEnd()
    - delStart()
    - delEnd()
    - delVal()
    - printList()

