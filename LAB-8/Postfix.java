import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public static int evalPost(String postfix) {
        
        Stack<Integer> stk = new Stack<>();
        int value = 0;

        for (int i = 0; i < postfix.length(); i++) {
            
            char temp = postfix.charAt(i);
            
            if(temp==','){
                continue;
            }
            
            if (Character.isDigit(temp)) {
                
                String digit = "";
                
                while (temp != ',') {
                    
                    digit += temp;
                    i++;
                    temp = postfix.charAt(i);
                }

                stk.push(Integer.parseInt(String.valueOf(digit)));
                continue;
            } 
            else {
                
                int op2 = stk.pop();
                int op1 = stk.pop();

                switch (temp) {
                    
                    case '+':
                        value = op1 + op2;
                        break;
                    case '-':
                        value = op1 - op2;
                        break;
                    case '*':
                        value = op1 * op2;
                        break;
                    case '/':
                        value = op1 / op2;
                        break;
                    case '^':
                        value = (int) Math.pow(op1, op2);
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

        System.out.print("Enter Posfix String(comma Separated) : ");
        String postfix = sc.nextLine();

        System.out.println(evalPost(postfix));

        sc.close();
    }
}