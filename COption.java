class Node
{
    int data;
    Node prev;
    Node next;

    Node(int d){
        data = d;
        prev = null;
        next = null;
    }
}

class DLL
{
    static Node head = null;

    public static void insertFront(int new_data)
    {
        Node new_Node = new Node(new_data);

        new_Node.next = head;

        if(head != null)
        {
            head.prev = new_Node;
        }

        head = new_Node;
    }

    public static void insert(Node next_node, int new_data)
    {
        if(next_node == null)
        {
            System.out.println("The next node is NULL");
        }

        Node new_Node = new Node(new_data);

        new_Node.prev = next_node.prev;

        next_node.prev = new_Node;

        new_Node.next = next_node;

        if(new_Node.prev != null)
        {
            new_Node.prev.next = new_Node;
        }
        else{
            head = new_Node;
        }

    }


    public static void randomInsert(Node prev_Node, int new_data)
    {
        if (prev_Node == null)
        {
            System.out.println("The previous node is NULL");

        }

        Node new_Node = new Node(new_data);

        new_Node.next = prev_Node.next;

        prev_Node.next = new_Node;

        new_Node.prev = prev_Node;

        if(new_Node.next != null)
        {
            new_Node.next.prev = new_Node;
        }
    }

    public static void insertRear(int new_data)
    {
        Node new_node = new Node(new_data);

        Node last = head;

        new_node.next = null;

        if(head == null)
        {
            new_node.prev = null;
            head = new_node;
        }

        while(last.next != null)
        {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;
    }

    void deleteNode(Node del)
    {
        if(head == null || del == null)
        {
            return;
        }

        if(head == del)
        {
            head = del.next;
        }

        if(del.next != null)
        {
            del.next.prev = del.prev;
        }

        if(del.prev != null)
        {
            del.prev.next = del.next;
        }
        
        return;
    }

    void deleteBoV(int value)
    {
        if(head == null)
        {
            return;
        }

        Node current = head;
        Node next;

        while(current != null)
        {
            if(current.data == value)
            {
                next = current.next;

                deleteNode(current);

                current = next;
            }
            else
            {
                current = current.next;
            }
        }
    }

    public static void printList(Node node)
    {
        Node last = null;

        System.out.println("The list contains: ");
        while(node != null)
        {
            System.out.println(node.data + "\n");
            last = node;
            node = node.next;
        }
    }

    

    public static void main(String[] args) {
        DLL dll = new DLL();
        
        insertFront(33);
        insertFront(57);
        insertRear(85);
        insertFront(95);
        printList(head);


        dll.deleteBoV(57);
        dll.deleteBoV(33);
        dll.deleteBoV(33);
        insertFront(22);
        dll.deleteBoV(95);
        printList(head);
    }
}