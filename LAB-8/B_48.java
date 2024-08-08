import java.util.Scanner;
import java.util.Stack;

public class B_48 {

    public static int evalPrefix(String prefix) {

        Stack<Integer> stk = new Stack<>();

        int value = 0;
        char temp;

        for (int i = prefix.length() - 1; i >= 0; i--) {

            temp = prefix.charAt(i);

            if (Character.isDigit(temp)) {

                stk.push(temp - '0');
            } else {

                int operand1 = stk.pop();
                int operand2 = stk.pop();

                switch (temp) {
                    case '+':
                        value = operand2 + operand1;
                        break;
                    case '-':
                        value = operand1 - operand2;
                        break;
                    case '*':
                        value = operand2 * operand1;
                        break;
                    case '/':
                        value = operand1 / operand2;
                        break;
                    case '^':
                        value = (int) (Math.pow(operand1, operand2));
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

        System.out.print("Enter Infix Expression : ");
        String prefix = sc.nextLine();

        System.out.print("Value : " + evalPrefix(prefix));

        sc.close();
    }
}