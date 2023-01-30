import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException, IOException {
        Converter converter = new Converter();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] str = buff.readLine().split(" ");
        String a = str[0];
        String b = str[1];
        String c = str[2];
        System.out.println(converter.calculate(a, b, c));
        System.out.println(converter.romanToInteger(a, b, c));
    }
}
