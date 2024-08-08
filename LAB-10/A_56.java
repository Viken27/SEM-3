public class A_56 {
 
    public static void main(String[] args) {
        
        LinkedListDemo node = new LinkedListDemo();

        node.insertAtFirst(1);
        node.insertAtLast(2);
        node.insertInOrder(3);

        node.copyLinkedList();
        node.displayNode(node);
    }
}