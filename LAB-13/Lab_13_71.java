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
public class Lab_13_71 {
    public static Node first=null;
    public static Node last=null;

    public static Node insertAtFirst(int data){
        Node newNode = new Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            last.next=newNode;
            return newNode;
        }else{
            newNode.next=first;
            first=newNode;
            last.next=first;
            return first;
        }
    }
    public void addNewNode(int value){
        Node newNode = new Node(value);
        if(first==null){
            first=newNode;
            last=newNode;
            last.next=first;
            
        }
        else{
           last.next=newNode;
           last = newNode;
           last.next=first;
            return;
           
        }
    }
    public void displayNode(){
        Node current=first;
        do{
            System.out.println(current.data);
            current=current.next;
        }while(current != first);
    }
    // public static void deleteAtPos(int pos){
    //     Node current=first;
    //     int count=0;
    //     do{
    //         count++;
    //         current=current.next;
    //     }while(current != first);
    //     System.out.println("the nodes are "+count);
    //     if(first==null){
    //         System.out.println("the list is empty nothing to delete ");
    //     }else{
            
    //         if(pos==1){
    //             first=first.next;
    //             last.next=first;
    //         }
    //         if(pos == count){
    //             while(current.next != last){
    //                 current=current.next;
    //             }
    //             current.next=first;
    //             current=last;
    //         }
    //         if(pos != 1 && pos !=count){
    //             while (current.next!=last && pos<count) {
    //                 current=current.next;
    //             }
    //             Node temp = current;
    //             temp=temp.next;
    //             current.next=temp.next;
    //         }
    //     }
    // }
    public static void deleteAtPos(int pos) {
        if (first == null) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }
    
        Node current = first;
        int count = 1;
    
        // Count the number of nodes in the list
        do {
            count++;
            current = current.next;
        } while (current != first);
    
        // If position is out of bounds
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }
    
        current = first;
    
        // Deleting the first node
        if (pos == 1) {
            if (first == last) { // Only one node in the list
                first = null;
                last = null;
            } else {
                first = first.next;
                last.next = first;
            }
            return;
        }
    
        // Deleting the last node
        if (pos == count) {
            while (current.next != last) {
                current = current.next;
            }
            current.next = first;
            last = current;
            return;
        }
    
        // Deleting a node in between
        int index = 1;
        while (index < pos - 1) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
    }
    
    public static void main(String[] args) {
        Lab_13_71 list = new Lab_13_71();
        list.addNewNode(1);
        list.addNewNode(2);
        list.addNewNode(3);
        list.addNewNode(4);

       // list.displayNode();
       // list.insertAtFirst(0);

       // list.displayNode();
       // list.deleteAtPos(1);
        
        list.deleteAtPos(4);
        list.displayNode();


    }
}
