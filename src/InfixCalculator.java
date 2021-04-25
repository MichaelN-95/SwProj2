import java.util.Scanner;

public class InfixCalculator {

    public static void main(String[] args) {

        //prompt user for input to test
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(evaluate(expression));
    }
    public static double evaluate(String expression){
        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> operands = new GenericStack<>();

        String[] parts = expression.split(" ");
        for(String currPart:parts) {
            switch (currPart) {
                case ("("):
                    break;
                case ("+"):
                case ("-"):
                case ("*"):
                case ("/"):
                    operators.push(currPart);
                    break;
                case (")"):
                    double rightOperand = operands.pop();
                    double leftOperand = operands.pop();
                    double result = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("+") -> result = leftOperand + rightOperand;
                        case ("-") -> result = leftOperand - rightOperand;
                        case ("*") -> result = leftOperand * rightOperand;
                        case ("/") -> result = leftOperand / rightOperand;
                    }
                    operands.push(result);
                    break;
                default:
                    operands.push(Double.parseDouble(currPart));
                    break;

            }
        }
        return (operands.pop());
    }
}
