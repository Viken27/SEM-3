import java.util.Scanner;

public class Stack {
 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Stack Size : ");
        int n = sc.nextInt();

        StackImplement node = new StackImplement(n);

        for (int i = 0 ;  i != n ; i++ ) {

            System.out.print("What Do You Want To Perform :-> \n\nEnter 1 For Push Element \nEnter 2 For Pop Element \nEnter 3 For Get Element From Top \nEnter 4 For Change Element From Top \nEnter 5 For Display Stack \nEnter 6 For Exit \nn = ");
            int x = sc.nextInt();

            switch (x) {

                case 1:
                    System.out.print("Enter Element For Push : ");
                    int a = sc.nextInt();
                    
                    node.push(a);
                    
                    System.out.println("After Add An Element :-> ");
                    node.displayStack();
                    
                    break;

                case 2:
                    System.out.print("Poped Element : " + node.pop());
                                        
                    break;

                case 3:
                    System.out.print("Enter Index To Get Element : ");
                    int c = sc.nextInt();
                    
                    node.peep(c);
                    
                    break;

                case 4:
                    System.out.print("Enter Index To Change Element : ");
                    int d = sc.nextInt();

                    System.out.print("Enter Element For Change : ");
                    int e = sc.nextInt();

                    node.change(d,e);
                    
                    break;

                case 5:
                    node.displayStack();
                    
                    break;

                case 6:
                    break;

                default:
                    System.out.print("Enter Valid Value");
                    
                    break;
            }
        }

        sc.close();
    }
}