import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException, CalculatorException {
        Converter converter = new Converter();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = buff.readLine().split(" ");
            String a = str[0];
            String b = str[1];
            String c = str[2];

            int ch0 = converter.romanToInteger(a);
            int ch2 = converter.romanToInteger(c);
            if (str.length > 3) {
                throw new CalculatorException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            Integer result = converter.calculate(ch0, b, ch2);
            System.out.println(converter.integerToRoman(result));

            int f = Integer.parseInt(a);
            int d = Integer.parseInt(c);
            if (f <= 10 && d <= 10) {
                Integer result2 = converter.calculate(f, b, d);
                System.out.println(result2);
            } else {
                throw new CalculatorException("Числа не могут быть более 10");
            }
        } catch (NumberFormatException e) {
            System.out.println("Используются одновременно разные системы счисления");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Строка не является математической операцией");
        }


    }
}


