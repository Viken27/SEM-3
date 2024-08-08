import java.util.Scanner;
import java.util.Stack;

public class A_47 {
    
    public static int evalPostfix(String postfix){

        Stack<Integer> stk = new Stack<>();

        int value = 0;
        char temp;
        
        for(int i = 0; i < postfix.length(); i++){

            temp = postfix.charAt(i);
            
            if(Character.isDigit(temp)){

                stk.push(Integer.parseInt(String.valueOf(temp)));
            }
            else{

                int operand2 = stk.pop();
                int operand1 = stk.pop();

                switch (temp) {
                    case '+': value = operand2 + operand1;
                        break;
                    case '-': value = operand1 - operand2;
                        break;
                    case '*': value = operand2 * operand1;
                        break;
                    case '/': value = operand1 / operand2;
                        break;
                    case '^': value = (int) (Math.pow(operand1, operand2));
                        break;
                    default:
                        break;
                }
                stk.push(value);
            }
        }
        return stk.pop();
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Postfix Expression : ");
        String postfix = sc.nextLine();

        System.out.print("Value : " + evalPostfix(postfix));

        sc.close();
    }
}