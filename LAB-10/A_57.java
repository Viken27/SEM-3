import java.util.Scanner;

public class A_57 {

    public static void main(String[] args) {

        LinkedListDemo node = new LinkedListDemo();

        Scanner sc = new Scanner(System.in);

        int n = 0;

        LinkedListDemo l = new LinkedListDemo();

        l.insertAtFirst(5);
        l.insertAtFirst(4);
        l.insertAtFirst(3);
        l.insertAtFirst(2);
        l.insertAtFirst(3);
        l.insertAtFirst(2);
        l.insertAtFirst(5);

        while ( n != 8 ) {

            System.out.print("What Do You Want To Perform :-> \nEnter 1 For Insert At First \nEnter 2 For Insert At Last \nEnter 3 For Insert In Order \nEnter 4 For Delete Node \nEnter 5 For Display \nEnter 6 For Copy Linked List \nEnter 7 Count Nodes \nEnter 8 For Sort Linked List \nEnter 9 For Check Linked List Is Same Or Not \nEnter 10 For Remove Duplicate From Linked List \nEnter 11 For Exit \nn = ");
            n = sc.nextInt();

            switch (n) {

                case 1:
                    System.out.print("Enter Node Value For Insert At First : ");
                    int a = sc.nextInt();
                    node.insertAtFirst(a);
                    System.out.println("After Add Node At First :-> ");
                    node.displayNode(node);
                    break;

                case 2:
                    System.out.print("Enter Node Value For Insert At Last : ");
                    int b = sc.nextInt();
                    node.insertAtLast(b);
                    System.out.println("After Add Node At Last :-> ");
                    node.displayNode(node);
                    break;

                case 3:
                    System.out.print("Enter Node Value For Insert In Order : ");
                    int c = sc.nextInt();
                    node.insertInOrder(c);
                    System.out.println("After Add Node In Order :-> ");
                    node.displayNode(node);
                    break;

                case 4:
                    System.out.print("Enter Node Value For Delete Node : ");
                    int d = sc.nextInt();
                    node.deleteNode(d);
                    System.out.println("After Delete Node :-> ");
                    node.displayNode(node);
                    break;

                case 5:
                    node.displayNode(node);
                    break;

                case 6:
                    node.copyLinkedList();
                    break;

                case 7:
                    int e = node.countNode();

                    if( e == 0 ){

                        System.out.println("Linked List Is Empty");
                    }
                    else{
                        System.out.println("LinkedList Nodes Is " + e );
                    }

                    break;

                case 8:
                    node.sortLinkedList();
                    break;

                case 9:
                    node.checkEquality(l);
                    break;
                
                case 10:
                    l.removeDuplicate();
                    break;

                case 11:
                    break;

                default:
                    System.out.print("Enter Valid Value");
                    break;
            }
        }

        sc.close();
    }
}