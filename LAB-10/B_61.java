import java.util.Scanner;

class QueueImpliment{
    int size;

    public QueueImpliment(int size){
        this.size=size;
    }
    class Node {

        int info;
        Node link;

        public Node(int info) {

            this.info = info;
            this.link = null;
        }
    }
    
    public Node head = null;

    public void add(int data){
        if(countNode()>=size){
            System.out.println("Queue is Full");
            return;
        }
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node save=head;
        while (save.link!=null) {
            save=save.link;
        }
        save.link=newNode;
    }
    public int peek(){
        if(countNode()==0){
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.info;
    }
    public int poll(){
        if(countNode()==0){
            System.out.println("Queue is Empty");
            return -1;
        }
        int temp=head.info;
        head=head.link;
        return temp;
    }
    public int countNode() {
        int count = 0;
        if (head == null) {
            count = 0;
            return count;
        }
        Node save = head;
        while (save != null) {
            count++;
            save = save.link;
        }
        return count;
    }
    public void displayQueue(){
        if(head==null){
            System.out.println("Queue Is Empty");
            return;
        }
        Node save=head;
        while (save!=null) {
            System.out.print(save.info+" ");
            save=save.link;
        }
    }
}
public class B_61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Queue : ");
        int n = sc.nextInt();
        QueueImpliment que=new QueueImpliment(n);

        int m;
        System.out.println("Enter Following Digits For Operations\n");
        System.out.println("1 for add");
        System.out.println("2 for peek()");
        System.out.println("3 for poll()");
        System.out.println("4 for display()");
        System.out.println("5 for exit");
        
        while (true) {
            System.out.print("Enter Digit for Operation : ");
            m = sc.nextInt();
            switch (m) {
                case 1:
                    System.out.print("Enter Element To add : ");
                    int x = sc.nextInt();
                    que.add(x);
                    break;
                case 2:
                    System.out.println(que.peek());
                    break;
                case 3:
                    System.out.println(que.poll());
                    break;
                case 4:
                que.displayQueue();
                    break;
                case 5:
                System.exit(0);
                    break;

                default:
                    System.out.println("Enter Valid Input");
                    break;
            }
        }
    }
}
