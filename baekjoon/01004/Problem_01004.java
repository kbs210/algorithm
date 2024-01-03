import java.util.Scanner;

public class Problem_01004{

    public static void main(String[] args) {
        
        // 어린왕자
        
        // T : 입력
        // x1, y1, x2, y2 : 출발점, 도착점
        // n : 행성 개수
        // cx, cy, r : 행성 위치, 반지름
        // -1000 <= x1, y1, x2, y2, cx, cy <= 1000
        // 1 <= r <= 1000
        // 1 <= n <= 50
        // 좌표와 반지름은 모두 정수

        // 경우의 수 3가지
        // 행성이 출발점, 도착점 모두 포함 0
        // 행성이 출발점, 도착점 모두 포함하지 않음 0
        // 그 외 1

        int T;


        Scanner scanner  = new Scanner(System.in);

        T = scanner.nextInt();

        int[] resultArray = new int[T];

        for(int t=0; t< T; t++){
            int x1;
            int y1;
            int x2;
            int y2;
            int n;
            int result = 0;

            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            n = scanner.nextInt();
    
            int[][] planetarySystemArray = new int[n][3];
            for(int i=0; i<n; i++){
                for(int j=0; j<3; j++){
                    planetarySystemArray[i][j] = scanner.nextInt();
                }
            }

            for(int i=0; i<n; i++){
                if(
                    (planetarySystemArray[i][0] - x1)*(planetarySystemArray[i][0] - x1) + 
                    (planetarySystemArray[i][1] - y1)*(planetarySystemArray[i][1] - y1)
                    > planetarySystemArray[i][2] * planetarySystemArray[i][2]
                    && 
                    (planetarySystemArray[i][0] - x2)*(planetarySystemArray[i][0] - x2) + 
                    (planetarySystemArray[i][1] - y2)*(planetarySystemArray[i][1] - y2)
                    > planetarySystemArray[i][2] * planetarySystemArray[i][2]
                ) {
                    result = result + 0;
                } else if (
                    (planetarySystemArray[i][0] - x1)*(planetarySystemArray[i][0] - x1) + 
                    (planetarySystemArray[i][1] - y1)*(planetarySystemArray[i][1] - y1)
                    < planetarySystemArray[i][2] * planetarySystemArray[i][2]
                    && 
                    (planetarySystemArray[i][0] - x2)*(planetarySystemArray[i][0] - x2) + 
                    (planetarySystemArray[i][1] - y2)*(planetarySystemArray[i][1] - y2)
                    < planetarySystemArray[i][2] * planetarySystemArray[i][2]
                ) {
                    result = result + 0;
                } else {
                    result = result + 1;
                }

            }

        resultArray[t] = result;

        }

        for(int t=0; t<T; t++){
            System.out.println(resultArray[t]);
        }
        
        scanner.close();

    }

}