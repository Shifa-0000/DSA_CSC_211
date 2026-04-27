import java.util.Scanner;

class Stack {
    int stack[] = new int[50];
    int top = -1;

    void push(int value) {
        top++;
        stack[top] = value;
    }

    int pop() {
        return stack[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        System.out.print("Enter postfix expression: ");
        String exp = sc.next();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                int num = ch - '0'; // convert char to int
                s.push(num);
            }

            // if operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                if (s.top < 1) {
                    System.out.println("Invalid expression!");
                    return;
                }

                int b = s.pop();
                int a = s.pop();

                int result = 0;

                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        if (b == 0) {
                            System.out.println("Division by zero error!");
                            return;
                        }
                        result = a / b;
                        break;
                }

                s.push(result);
            }
            
            else {
                System.out.println("Invalid character in expression!");
                return;
            }
        }

        if (s.top == 0) {
            System.out.println("Result: " + s.pop());
        } else {
            System.out.println("Invalid expression!");
        }
    }
}