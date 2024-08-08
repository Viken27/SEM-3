import java.util.Scanner;

public class B_46 {

    public static int GS(char temp) {

        switch (temp) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            case ')':
                return 0;

            default:
                return -1;
        }
    }

    public static int G(char next) {

        if (next == '+' || next == '-') {
            return 1;
        } else if (next == '*' || next == '/') {
            return 3;
        } else if (next == '^') {
            return 6;
        } else if (next >= 'a' && next <= 'z') {
            return 8;
        } else if (next == '(') {
            return 0;
        }
        return -1;
    }

    public static int F(char next) {

        if (next == '+' || next == '-') {
            return 2;
        } else if (next == '*' || next == '/') {
            return 4;
        } else if (next == '^') {
            return 5;
        } else if (next >= 'a' && next <= 'z') {
            return 7;
        } else if (next == '(') {
            return 9;
        } else if (next == ')') {
            return 0;
        }
        return -1;
    }

    public static int R(char next) {

        if (next == '+' || next == '-' || next == '*' || next == '/' || next == '^') {
            return -1;
        } else if (next >= 'a' && next <= 'z') {
            return 1;
        }
        return 0;
    }

    public static String getPrefixShortCut(String infix, StringBuffer postfix) {

        Stack_Polish stack = new Stack_Polish(infix.length());

        stack.push('(');

        for (int i = 0; i < infix.length(); i++) {

            char temp = infix.charAt(i);

            if (temp >= 'a' && temp <= 'z') {

                postfix.append(temp);
            } else {

                if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {

                    while (G(stack.peep(1)) > G(temp)) {

                        postfix.append(stack.pop());
                    }

                    stack.push(temp);
                } else {

                    if (temp == '^') {

                        while (G(stack.peep(1)) >= G(temp)) {

                            postfix.append(stack.pop());
                        }

                        stack.push(temp);
                    } else {

                        if (temp == '(') {

                            stack.push(temp);
                        } else {

                            if (temp == ')') {

                                char temp2 = stack.pop();

                                while (temp2 != '(') {

                                    postfix.append(temp2);

                                    temp2 = stack.pop();
                                }
                            }
                        }
                    }
                }
            }
        }

        return postfix.toString();
    }

    public static String getPrefix(String infix, StringBuffer postfix) {

        Stack_Polish stk = new Stack_Polish(infix.length());

        stk.push('(');

        int rank = 0;

        for (int i = 0; i < infix.length(); i++) {

            char next = infix.charAt(i);

            if (stk.top < 0) {

                System.out.println("Invalid");
                return null;
            }

            while (G(stk.peep(1)) > F(next)) {

                char temp = stk.pop();
                postfix.append(temp);
                rank += R(temp);

                if (rank < 1) {

                    System.out.println("Invalid");
                    return null;
                }
            }
            if (G(stk.peep(1)) != F(next)) {

                stk.push(next);
            } else {

                stk.pop();
            }
        }

        if (stk.top != -1 || rank != 1) {

            System.out.println("Invalid");
            return null;
        } else {

            return postfix.toString();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Infix Expression : ");
        String str = sc.nextLine().toLowerCase();

        String infix = "";

        for (int i = str.length() - 1; i >= 0; i--) {

            char temp = str.charAt(i);

            if (temp == '(') {
                infix += ")";
            } else if (temp == ')') {
                infix += "(";
            } else {
                infix += temp;
            }
        }

        infix = infix + ")";

        StringBuffer postfix = new StringBuffer("");

        String ans = getPrefixShortCut(infix, postfix);

        String prefix = "";
        
        for (int i = ans.length() - 1; i >= 0; i--) {

            prefix += ans.charAt(i);
        }

        System.out.print("Prefix Expression : " + prefix);

        sc.close();
    }
}