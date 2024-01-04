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

            // 중복순열 공식 이용
            // nCr = n!/(r!*(n-r)!) = n*(n-1)* ... *(n-r+1)/n!

            // n*(n-1)* ... *(n-r+1)
            BigInteger numerator = new BigInteger("1");
            for(int x=0; x<b; x++) {
                numerator = numerator.multiply(BigInteger.valueOf(M));
                M--;
            }

            // n!
            BigInteger denominator = new BigInteger("1");
            for(int x=0; x<b; x++) {
                denominator = denominator.multiply(BigInteger.valueOf(N));
                N--;
            }

            // n*(n-1)* ... *(n-r+1)/n!
            list[i] = numerator.divide(denominator);
        }

        for (BigInteger value: list) {
            System.out.println(value);
        }

    }

}

