enum car
{
    Ford,
    GMC,
    RAM,
    Chevy
}

enum plane
{
    Boeing,
    Piper,
    Cessna
}

class node<C, S>
{
    C data;
    S data2;

    node<C, S> next;
    node<C, S> prev;

    node(C data, S data2)
    {
        this.data = data;
        this.data2 = data2;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList<C, S>
{
    node<C, S> head;

    int length = 0;

    DoublyLinkedList()
    {
        this.head = null;
    }

    void insertFront(C data, S data2)
    {
        //creating a new node
        node<C, S> newNode = new node(data, data2);

        newNode.next = head;

        if(head != null)
        {
            head.prev = newNode;
        }
        head = newNode;

        length ++;
    }

    void insertRear(C data, S data2)
    {
        node<C, S> newNode = new node(data, data2);

        node<C, S> last = head;

        newNode.next = null;

        if(head == null)
        {
            newNode.prev = null;
            head = newNode;
            return;
        }
            
        while(last.next != null)
        {
            last = last.next;
        }
        
        last.next = newNode;
        newNode.prev = last;

        length ++;
    }

    void delete(node<C, S> del)
    {
        if(head == null || del == null)
        {
            System.out.println("head or delete pointer is null (IN DELETE)");
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

        length --;
        return;

    }

    void delValue(C data)
    {
        if(head == null)
        {
            System.out.println("The head pointer is null (IN DELETE VALUE)");
            return;
        }

        node<C, S> currentNode = head;
        node<C, S> nextNode;

        //loop to traverse the list
        while(currentNode != null)
        {

            if(currentNode.data == data)
            {
                nextNode = currentNode.next;
                delete(currentNode);
                currentNode = nextNode;
                return;
            }
            else
            {
                currentNode = currentNode.next;
            }

        }
    }

    void printLength()
    {
        System.out.println("The length of the list is (STARTING AT 0): "+ length);
    }

    public String toString()
    {
        node<C, S> node = head;
        String s = "";

        System.out.println("The list contains: \n");
        if(node == null)
        {
            s = "The string is empty";
            return s;
        }

        while (node.next != null)
        {
            s += String.valueOf(node.data) + String.valueOf(node.data2) + "\n";
            node = node.next;
        }
        s+= String.valueOf(node.data) + String.valueOf(node.data2) + "\n";
        return s;
    }

    public static void main(String[] args)
    {
        DoublyLinkedList<car,String> DLL = new DoublyLinkedList();

        DLL.insertRear(car.Ford, " with 4 doors");
        DLL.insertFront(car.Ford, " with 2 doors");
        DLL.insertRear(car.GMC, " with 2 doors");
        DLL.insertRear(car.RAM, " with 2 doors");
        DLL.insertFront(car.Chevy, " with 3 doors");

        System.out.println(DLL);
        DLL.printLength();

        DLL.delValue(car.Ford);

        System.out.println(DLL);

    }
}