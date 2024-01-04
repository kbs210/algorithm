import java.math.BigInteger;
import java.util.*;

public class Problem_01010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        BigInteger[] list = new BigInteger[a];

        for(int i=0; i<a; i++) {
            int b, c;
            b = sc.nextInt();
            c = sc.nextInt();

            int N = b;
            int M = c;

            BigInteger numerator = new BigInteger("1");
            for(int x=0; x<b; x++) {
                numerator = numerator.multiply(BigInteger.valueOf(M));
                M--;
            }

            BigInteger denominator = new BigInteger("1");
            for(int x=0; x<b; x++) {
                denominator = denominator.multiply(BigInteger.valueOf(N));
                N--;
            }

            list[i] = numerator.divide(denominator);
        }

        for (BigInteger value: list) {
            System.out.println(value);
        }

    }

}

