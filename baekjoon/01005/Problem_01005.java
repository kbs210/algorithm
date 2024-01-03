import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

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
            int result = 0;
            int N = 0;
            int K = 0;

            N = scanner.nextInt();
            K = scanner.nextInt();

            int[] dArray = new int[N];
            int[][] xyArray = new int[K][2];
            
            for(int j=0; j<N; j++){
                dArray[j] = scanner.nextInt();
            }
            
            for(int j=0; j<K; j++){
                xyArray[j][0] = scanner.nextInt();
                xyArray[j][1] = scanner.nextInt();
            }
            
            int W = 0;
            W = scanner.nextInt();

            // 로직 시작

            int[][] nArray = new int[N][N];

            for(int m=0; m<N; m++){
                for(int n=0; n<N; n++){
                    nArray[m][n] = 0;
                }
            }

            nArray[0][0] = W;

            
            
            for(int m=0; m<N; m++){
                
            }





            // 로직 종료

            resultArray[i] = result;
        }

        scanner.close();
        
    }

}
