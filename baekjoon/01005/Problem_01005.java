import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_01005 {

    public static void main(String[] args) {

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

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int[] dArray = new int[N];
            int[][] xyArray = new int[K][2];

            for (int j = 0; j < N; j++) {
                dArray[j] = scanner.nextInt();
            }

            for (int j = 0; j < K; j++) {
                xyArray[j][0] = scanner.nextInt();
                xyArray[j][1] = scanner.nextInt();
            }

            int W = scanner.nextInt();

            // 로직 시작

            // 기초 건물, Y 없는 건물
            int[] base = new int[N];
            Arrays.fill(base, -1);
            for (int a = 0; a < K; a++) {
                base[xyArray[a][1] - 1] = 0;
            }

            int[] buildTime = new int[N];
            for (int a = 0; a < N; a++) {
                if (base[a] == -1) {
                    buildTime[a] = dArray[a];
                }
            }

            System.out.println(Arrays.toString(dArray));
            System.out.println(Arrays.toString(base));
            System.out.println(Arrays.toString(buildTime));

            boolean check=false;
            do {
                for (int a = 0; a < N; a++) {
                    if (base[a] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        boolean flag = false;
                        for (int b = 0; b < K; b++) {
                            if (xyArray[b][1] == a + 1 && base[xyArray[b][0] - 1] == -1) {
                                list.add(xyArray[b][0]);
                            } else {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            continue;
                        }
                        if (!list.isEmpty()) {
                            int size = list.size();
                            int[] temp = new int[size];
                            for (int c = 0; c < size; c++) {
                                temp[c] = buildTime[list.get(c) - 1];
                            }
                            Arrays.sort(temp);
                            buildTime[a] = temp[size - 1];
                            base[a] = -1;
                        }
                    }
                }

                System.out.println(Arrays.toString(dArray));
                System.out.println(Arrays.toString(base));
                System.out.println(Arrays.toString(buildTime));

                for (int a = 0; a < N; a++) {
                    if (base[a] == 0) {
                        check=true;
                        break;
                    }
                }
            } while (check);


            // 로직 종료
        }

        scanner.close();

    }

}
