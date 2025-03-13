import java.util.Scanner;

public class Tp01Q05 {

    public static int skipParentheses(String expr, int index, int counter) {
        while (index < expr.length()) {
            char currentChar = expr.charAt(index);
            if (currentChar == ')' && counter == 0) {
                return index + 1;
            }
            if (currentChar == ')' && counter > 0) {
                index = skipParentheses(expr, index + 1, counter - 1);
            }
            if (currentChar == '(') {
                index = skipParentheses(expr, index + 1, counter + 1);
            }
            index++;
        }
        return index;
    }

    public static int evaluateAnd(String expr, int index, int result, boolean isFirstOperand, int A, int B, int C) {
        while (index < expr.length()) {
            char currentChar = expr.charAt(index);
            if (currentChar == 'A') {
                result = isFirstOperand ? A : result * A;
            } else if (currentChar == 'B') {
                result = isFirstOperand ? B : result * B;
            } else if (currentChar == 'C') {
                result = isFirstOperand ? C : result * C;
            } else if (currentChar == 'a') {
                index = skipParentheses(expr, index, -1);
                result = evaluateAnd(expr, index + 2, 0, true, A, B, C);
            } else if (currentChar == 'o') {
                index = skipParentheses(expr, index, -1);
                result = evaluateAnd(expr, index + 1, 0, true, A, B, C);
            } else if (currentChar == 'n') {
                index = skipParentheses(expr, index, -1);
                result = evaluateAnd(expr, index + 2, 0, true, A, B, C);
            } else if (currentChar == ')') {
                return result;
            }
            index++;
        }
        return result;
    }

    public static int evaluateOr(String expr, int index, int result, boolean isFirstOperand, int A, int B, int C) {
        if (result > 1) result = 1;

        while (index < expr.length()) {
            char currentChar = expr.charAt(index);
            if (currentChar == 'A') {
                result = isFirstOperand ? A : result + A;
            } else if (currentChar == 'B') {
                result = isFirstOperand ? B : result + B;
            } else if (currentChar == 'C') {
                result = isFirstOperand ? C : result + C;
            } else if (currentChar == 'a') {
                index = skipParentheses(expr, index, -1);
                result = evaluateOr(expr, index + 2, 0, true, A, B, C);
            } else if (currentChar == 'o') {
                index = skipParentheses(expr, index, -1);
                result = evaluateOr(expr, index + 1, 0, true, A, B, C);
            } else if (currentChar == 'n') {
                index = skipParentheses(expr, index, -1);
                result = evaluateOr(expr, index + 2, 0, true, A, B, C);
            } else if (currentChar == ')') {
                return result;
            }
            index++;
        }
        return result;
    }

    public static int evaluateNot(String expr, int index, int result, int A, int B, int C) {
        while (index < expr.length()) {
            char currentChar = expr.charAt(index);
            if (currentChar == 'A') {
                result = 1 - A;
            } else if (currentChar == 'B') {
                result = 1 - B;
            } else if (currentChar == 'C') {
                result = 1 - C;
            } else if (currentChar == 'a') {
                index = skipParentheses(expr, index, -1);
                result = 1 - evaluateAnd(expr, index + 2, 0, true, A, B, C);
            } else if (currentChar == 'o') {
                index = skipParentheses(expr, index, -1);
                result = 1 - evaluateOr(expr, index + 1, 0, true, A, B, C);
            } else if (currentChar == 'n') {
                index = skipParentheses(expr, index, -1);
                result = 1 - evaluateNot(expr, index + 2, 0, A, B, C);
            } else if (currentChar == ')') {
                return result;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();

        while (expr.charAt(0) - '0' > 1) {
            int shift = (expr.charAt(0) - '0' == 3) ? 2 : 0;
            int A = expr.charAt(2) - '0';
            int B = expr.charAt(4) - '0';
            int C = expr.charAt(6) - '0';

            char operator = expr.charAt(6 + shift);

            switch (operator) {
                case 'a':
                    System.out.println(evaluateAnd(expr, 9 + shift, 0, true, A, B, C));
                    break;
                case 'n':
                    System.out.println(evaluateNot(expr, 9 + shift, 0, A, B, C));
                    break;
                case 'o':
                    System.out.println(evaluateOr(expr, 8 + shift, 0, true, A, B, C));
                    break;
            }
            expr = scanner.nextLine();
        }
        scanner.close();
    }
}
