package postfix;
import java.util.*;

public class ToPostfix {
    private static int getPriority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char token : infix.toCharArray()) {
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(" ").append(operatorStack.pop());
                }
                operatorStack.pop(); // '(' 제거
            } else {
                while (!operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(token)) {
                    postfix.append(" ").append(operatorStack.pop());
                }
                operatorStack.push(token);
                postfix.append(" ");
            }
        }
        while (!operatorStack.isEmpty()) {
            postfix.append(" ").append(operatorStack.pop());
        }
        return postfix.toString().trim();
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Input infix expression>> ");
    	String infix = scanner.nextLine();        
        
        String postfix = infixToPostfix(infix);
        System.out.println("postfix expression: " + postfix);
        
        scanner.close();
    }
}