import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem_01006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> innerPosition = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                innerPosition.add(Integer.parseInt(st.nextToken()));
            }
            ArrayList<Integer> outterPosition = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                outterPosition.add(Integer.parseInt(st.nextToken()));
            }

            System.out.printf(Arrays.toString(innerPosition.toArray()));
            System.out.printf(Arrays.toString(innerPosition.toArray()));

            // 쪼갤 수 있는 경우의 수
            /*
                0. 전체 1구역
                1. 외각에만 2구역 존재
                2. 내각에만 2구역 존재
                3. 외-내각에 모두 2구역 존재
                4. 외각, 외-내각으로 2구역 존재
                5. 내각, 외-내각으로 2구역 존재
                6. 외각, 내각, 외내각 2구역 존재
             */

            // 경우의 수 중 소대 초과 경우 제거

            // 최소 소대 수
        }

        br.close();
        bw.close();
    }

}
