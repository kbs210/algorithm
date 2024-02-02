import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem_01005 {

    public static void main(String[] args) throws IOException {

        // DFS Deep First Search 깊이 우선 탐색 - 시작 노드에서 자식의 노드들을 순서대로 탐색하면서 깊이를 우선으로 탐색하는 알고리즘
        // BFS Breath First Search  너비 우선 탐색 - 시작 정점을 방문한 후 시작 정점에 인접한 모든 정점들을 우선 방문하는 방법

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // buildTimeList 건물 건설 시간 리스트
            ArrayList<Integer> buildTimeList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                buildTimeList.add(Integer.parseInt(st.nextToken()));
            }

            // x, y 전체 규칙 리스트
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x.add(Integer.parseInt(st.nextToken()));
                y.add(Integer.parseInt(st.nextToken()));
            }

            int W = Integer.parseInt(br.readLine());

            int[] actualBuildTime = new int[N];

            int[] inDegree = new int[N]; // 진입 차수
            List<List<Integer>> graph = new ArrayList<>(); // 그래프
            for (int k = 0; k < N; k++) {
                graph.add(new ArrayList<>());
            }
            // 의존성 그래프와 진입 차수 초기화
            for (int k = 0; k < y.size(); k++) {
                graph.get(x.get(k) - 1).add(y.get(k) - 1);
                inDegree[y.get(k) - 1]++;
            }

            // 위상 정렬을 위한 준비
            Arrays.fill(actualBuildTime, -1);
            Queue<Integer> queue = new LinkedList<>();
            for (int k = 0; k < N; k++) {
                if (inDegree[k] == 0) {
                    queue.add(k);
                    actualBuildTime[k] = buildTimeList.get(k); // 진입 차수가 0이면 바로 건설 가능
                }
            }

            // 위상 정렬 수행하며 건설 시간 계산
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next: graph.get(current)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                    actualBuildTime[next] = Math.max(actualBuildTime[next], actualBuildTime[current] + buildTimeList.get(next));
                }
            }



            bw.append(Integer.toString(actualBuildTime[W - 1])).append("\n");
            // 로직 종료
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
