import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException, CalculatorException {
        Converter converter = new Converter();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] str = buff.readLine().split(" ");
        if (str.length > 3) {
            throw new CalculatorException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (str.length < 3) {
            throw new CalculatorException("Строка не является математической операцией");
        }
        String a = str[0];
        String b = str[1];
        String c = str[2];
        if (converter.checkNumber(a) == true && converter.checkNumber(c) == false) {
            throw new CalculatorException("Используются одновременно разные системы счисления");
        } else if (converter.checkNumber(a) == false && converter.checkNumber(c) == true) {
            throw new CalculatorException("Используются одновременно разные системы счисления");
        }

        if (converter.checkNumber(a) == true && converter.checkNumber(c) == true) {
            int f = Integer.parseInt(a);
            int d = Integer.parseInt(c);
            if (f <= 10 && d <= 10) {
                Integer result2 = converter.calculate(f, b, d);
                System.out.println(result2);
            } else {
                throw new CalculatorException("Числа не могут быть более 10");
            }
        } else {
            int ch0 = converter.romanToInteger(a);
            int ch2 = converter.romanToInteger(c);
            if (ch0 < 1 || ch2 < 1) {
                throw new CalculatorException("Числа не могут быть более 10");
            } else {
                Integer result = converter.calculate(ch0, b, ch2);
                System.out.println(converter.integerToRoman(result));
            }
        }
    }
}











     /*       try {
                Integer result = converter.calculate(ch0, b, ch2);
                System.out.println(converter.integerToRoman(result));
            } catch (NumberFormatException e) {
                throw new CalculatorException("Числа не могут быть более 10");
            }
            } else if (ch0 == 0 && ch2 == 0) {
            int f = Integer.parseInt(a);
            int d = Integer.parseInt(c);
            if (f <= 10 && d <= 10) {
                Integer result2 = converter.calculate(f, b, d);
                System.out.println(result2);
            } else {
                throw new CalculatorException("Числа не могут быть более 10");
            }
        } else {
            throw new CalculatorException("Используются одновременно разные системы счисления");
        }
    }
}*/


