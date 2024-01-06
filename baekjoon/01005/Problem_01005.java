import java.util.Arrays;
import java.util.Scanner;

public class Problem_01005 {
    
    public static void main(String[] args){

        // ACM Craft

        // T : 테스트 케이스 개수
        // N : 건물의 개수
        // K : 건설순서 규칙 개수
        // D1, D2, ... , DN : 건물당 건설 시간
        // X, Y : 건설 순서
        // W : 승리 건물 번호

        // 2 <= N <= 1000
        // 1 <= K <= 100000
        // 1 <= X, Y, W <= N
        // 0 <= Di <= 100000 정수
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] resultArray = new int[T];

        for(int i=0; i<T; i++){
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[] dArray = new int[N];
            int[][] xyArray = new int[K][2];
            
            for(int j=0; j<N; j++){
                dArray[j] = scanner.nextInt();
            }
            
            for(int j=0; j<K; j++){
                xyArray[j][0] = scanner.nextInt();
                xyArray[j][1] = scanner.nextInt();
            }
            
            int W = scanner.nextInt();

            // 로직 시작

            // 기초 건물, Y 없는 건물
            int[] base = new int[N];
            for(int a=0; a<K; a++) {
                base[xyArray[a][1]-1] = 1;
            }

            int baseCnt=0;
            for (int a=0; a<K; a++) {
               baseCnt = K - base[a];
            }



            System.out.println(Arrays.toString(base));



            // 로직 종료
        }

        scanner.close();
        
    }

}
