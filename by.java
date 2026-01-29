import java.util.Scanner;
import java.util.Stack;

public class by {

    
    static int priority(char op) {
        if (op == '^')
            return 3;
        if (op == '*' || op == '/' || op == '%')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        String pfix = "";

        System.out.print("Enter infix expression: ");
        String ifix = in.next();

        for (int i = 0; i < ifix.length(); i++) {
            char ch = ifix.charAt(i);

            // If operand, add to postfix
            if (Character.isLetterOrDigit(ch)) {
                pfix += ch;
            }

            // If '(' push to stack
            else if (ch == '(') {
                st.push(ch);
            }

            // If ')' pop until '('
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    pfix += st.pop();
                }
                st.pop(); // remove '('
            }

            // Operator case
            else {
                while (!st.isEmpty() && priority(st.peek()) >= priority(ch)) {
                    pfix += st.pop();
                }
                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            pfix += st.pop();
        }

        System.out.println("Postfix expression: " + pfix);
        in.close();
    }
}
