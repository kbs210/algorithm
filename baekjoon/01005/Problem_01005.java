import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_01005 {

    public static void main(String[] args) throws IOException {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] resultArray = new int[T];

        for (int i = 0; i < T; i++) {
            String line1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(line1, " ");

            int N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());

            int[] dArray = new int[N];
            int[][] xyArray = new int[K][2];

            String line2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(line2, " ");
            for (int j = 0; j < N; j++) {
                dArray[j] = Integer.parseInt(st2.nextToken());
            }

            for (int j = 0; j < K; j++) {
                String line3 = br.readLine();
                StringTokenizer st3 = new StringTokenizer(line3, " ");
                xyArray[j][0] = Integer.parseInt(st3.nextToken());
                xyArray[j][1] = Integer.parseInt(st3.nextToken());
            }

            int W = Integer.parseInt(br.readLine());

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

            boolean check;
            do {
                check=false;
                for (int a = 0; a < N; a++) {
                    if (base[a] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        boolean flag = false;
                        for (int b = 0; b < K; b++) {
                            if (xyArray[b][1] == a + 1) {
                                if (base[xyArray[b][0] - 1] == -1) {
                                    list.add(xyArray[b][0]);
                                } else {
                                    flag = true;
                                    break;
                                }
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
                            buildTime[a] = temp[size - 1] + dArray[a];
                            base[a] = -1;
                        }
                    }
                }

                for (int d = 0; d < N; d++) {
                    if (base[d] == 0) {
                        check = true;
                        break;
                    }
                }
            } while (check);


            resultArray[i] = buildTime[W - 1];
            // 로직 종료
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a = 0; a < T; a++) {
            bw.write(resultArray[a] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
