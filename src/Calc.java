import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате (x + y):");
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public static String calc(String input) throws Exception {
        String[] expression = input.split(" ");

        if (expression.length != 3) {
            throw new Exception("Некорректный ввод выражения");
        }

        int number1 = parseNumber(expression[0]);
        int number2 = parseNumber(expression[2]);
        String operator = expression[1];

        int result;
        switch (operator) {
            case "+" -> result = number1 + number2;
            case "-" -> result = number1 - number2;
            case "*" -> result = number1 * number2;
            case "/" -> {
                if (number2 == 0) {
                    throw new Exception("На ноль делить нельзя");
                }
                result = number1 / number2;
            }
            default -> throw new Exception("Оператор должен быть вида: +, -, *, /");
        }

        return String.valueOf(result);
    }

    public static int parseNumber(String value) throws Exception {
        try {
            int number = Integer.parseInt(value);
            if (number < 1 || number > 10) {
                throw new Exception("Неверный диапазон числа");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат числа");
        }
    }
}
