import java.util.*;

public class Problem_01009 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        int[] list = new int[a];

        for(int i=0; i<a; i++) {
            int b, c;
            b = sc.nextInt();
            c = sc.nextInt();

            int x = (b%10);
            int y = (b%10);
            for(int j=0; j<c-1; j++) {
                y = (y*x)%10;
            }

            if(y==0) {
                list[i] = 10;
            } else {
                list[i] = y;
            }
        }

        for (int value: list) {
            System.out.println(value);
        }

    }
}

