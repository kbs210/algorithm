import java.util.*;

public class Problem_01010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        int[] list = new int[a];

        for(int i=0; i<a; i++) {
            int b, c;
            b = sc.nextInt();
            c = sc.nextInt();

            int s = c-b+1;
            for(int x=s; x>0; --x) {
                for(int y=x; y>0; --y){
                    list[i] = list[i]+y;
                }
            }
        }

        for (int value: list) {
            System.out.println(value);
        }

    }
}

