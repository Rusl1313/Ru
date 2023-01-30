public class Converter {
    public String romanToInteger(String roman, String operator, String roman2) {
        String[] letters = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        Integer[] result = new Integer[2];
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(roman)) {
                result[0] = i;
            }
        }
        for (int j = 0; j < letters.length; j++) {
            if (letters[j].equals(roman2)) {
                result[1] = j;
            }

        }
        Integer x = calculate2(result[0], operator, result[1]);
        return integerToRoman(x);


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

    public int calculate2(Integer a, String operator, Integer b) {
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


    public Integer calculate(String a, String operator, String b) {
        int f = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        int sum = 0;
        switch (operator) {
            case "+":
                sum = f + d;
                break;
            case "-":
                sum = f - d;
                break;
            case "*":
                sum = f * d;
                break;
            case "/":
                sum = f / d;
                break;

        }
        return sum;
    }
}
