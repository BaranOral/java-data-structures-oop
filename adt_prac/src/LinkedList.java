public class LinkedList<T> {

    private class Node{
        T data;
        Node next;
        public Node(T dataPortion){
            this(dataPortion,null);
        }
        public Node(T dataPortion,Node nextnode){
            data=dataPortion;
            next=nextnode;
        }
    }

    Node head;
    private int size;
    
    public void add(T newEntry){
        Node node = new Node(newEntry);
        node.data=newEntry;
        node.next=null;
        if (head==null){
            head=node;
            size++;
        }
        else{
            Node n = head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
            size++;
        }
    }
    
    public void insertAtStart(T newEntry){
        Node node = new Node(newEntry);
        node.data= newEntry;
        node.next=head;
        head=node;
        size++;

    }
    
    public void insertAt(int index,T newEntry){
        Node node = new Node(newEntry);
        node.data=newEntry;
        node.next=null;
        if (index==0){
            insertAtStart(newEntry);
        }
        else{
            Node n = head;
            for  (int i=0;i<index-1;i++){
                n=n.next;
            }
            node.next=n.next;
            n.next=node;
            size++;
        }
    }
    
    public void delete(int index){
        if (index==0){
            head=head.next;
            size--;
        }
        else{
            Node n = head;
            Node n1= null;
            for (int i=0;i<index-1;i++){
                n = n.next;
            }
            n1=n.next;
            n.next=n1.next;
            n1=null;
            size--;
        }
    }

    public T returnFirst(){
        return head.data;
    }
    
    public T returnIndex(int index){
        Node node = head;
        for(int i=0; i < index ;i++){
            node = node.next;
        }
        return node.data;
    }
    
    public int getSize(){
        return size;
    }

}