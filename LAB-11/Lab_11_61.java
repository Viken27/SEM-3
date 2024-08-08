class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }

}
public class Lab_11_61 {
    private Node head;

    public void addNewNode(int value){
        Node newNode = new Node(value);
        if(head==null){
            head=newNode;
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
    }
    public void printNode(){
        Node current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public void enqueue(int value){
        Node newNode=new Node(value);
        if(head==null){
            head = newNode;
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }

    }
    public void dequeue(){
        if(head==null){
            System.out.println("the list is empty so nothing is to delete at first ");
        }else{
            Node current=head;
            current=head.next;
            head=current;
        }
    }
    public static void main(String[] args) {
        Lab_11_61 list = new Lab_11_61();

        list.addNewNode(1);
        list.addNewNode(2);
        list.addNewNode(3);
        list.addNewNode(4);

        list.printNode();
        System.out.println("after enqueing .....");
        list.enqueue(5);
        list.enqueue(6);

        list.printNode();
        list.dequeue();
        System.out.println("after dequeing .....");
        list.printNode();

    }
}