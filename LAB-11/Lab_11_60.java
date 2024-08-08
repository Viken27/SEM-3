import java.util.EmptyStackException;
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
class Stack {
    private Node top; 
    public Stack() {
        this.top = null; 
    }

    
    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; 
        top = newNode; 
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = top.data;        
        top = top.next;       
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;  
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Lab_11_60 {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.display();

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        stack.display();

        System.out.println("Top element: " + stack.peek());
    }
}