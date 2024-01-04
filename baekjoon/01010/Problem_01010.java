import java.util.*;

public class Problem_01010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        long[] list = new long[a];

        for(int i=0; i<a; i++) {
            int b, c;
            b = sc.nextInt();
            c = sc.nextInt();

            long N = b;
            long M = c;
            long P = c-b;

            long numerator = 1;
            for(int x=0; x<c; x++) {
                numerator = numerator*M;
                M--;
            }

            long denominatorFirst = 1;
            for(int x=0; x<b; x++) {
                denominatorFirst = denominatorFirst * N;
                N--;
            }

            long denominatorSecond = 1;
            for(int x=0; x<(c-b); x++) {
                denominatorSecond = denominatorSecond * P;
                P--;
            }

            list[i] = numerator/(denominatorFirst*denominatorSecond);
        }

        for (long value: list) {
            System.out.println(value);
        }

    }
}

