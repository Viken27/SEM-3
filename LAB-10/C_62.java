public class C_62 {
 
    public static void main(String[] args) {
        
        LinkedListDemo node = new LinkedListDemo();

        node.insertAtFirst(5);
        node.insertAtFirst(5);
        node.insertAtFirst(3);
        node.insertAtFirst(2);
        node.insertAtFirst(3);
        node.insertAtFirst(5);

        node.removeDuplicate();
    }
}