public class Converter {
    public Integer romanToInteger(String roman) throws CalculatorException {
        String letters[] = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(roman)) {
                return i;
            }
        }
        return 0;
    }

    public String integerToRoman(Integer number) {
        StringBuffer result = new StringBuffer();
        int[] uniqueNumber = new int[]{1, 4, 5, 9, 10, 40, 50};
        String[] arrSymbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "C"};
        int size = uniqueNumber.length - 1;
        while (number > 0) {
            int count = number / uniqueNumber[size];
            while (count > 0) {
                result.append(arrSymbol[size]);
                count--;
            }
            number = number % uniqueNumber[size];
            size--;
        }
        return result.toString();
    }

    public Integer calculate(Integer a, String operator, Integer b) throws CalculatorException {
        if (a < b && operator.equals("-")) {
            throw new CalculatorException("В римской системе нет отрицательных чисел и нуля");
        }
        int sum = 0;
        switch (operator) {
            case "+":
                sum = a + b;
                break;
            case "-":
                sum = a - b;
                break;
            case "*":
                sum = a * b;
                break;
            case "/":
                sum = a / b;
                break;

        }
        return sum;
    }
    public boolean checkNumber(String a) {
        if (a == null || a.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
