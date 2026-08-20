import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluate(String expression) {

        Stack<Integer> st = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            if (token.matches("-?\\d+")) {
                st.push(Integer.parseInt(token));
            }

            else {
                int b = st.pop();
                int a = st.pop();

                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;

                    case "^":
                        result = (int) Math.pow(a, b);
                        break;
                }

                st.push(result);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        System.out.println(evaluate(expression));

        sc.close();
    }
}