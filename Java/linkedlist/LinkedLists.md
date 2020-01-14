#### tip 1
Always use Node n = head; as a aux node to loop through.

#### tip 2
Think of loop using n.next instead of n. Ex: while (n.next != null) n = n.next;

#### tip 3
n = n.next won't change head unless you return this Node in the method, but if you change n.next or some property inside this
aux n, it will change head (it isn't a copy of ref anymore). This is important to delete a node. Prefer to do this: 
n.next = n.next.next to effectively change head.

