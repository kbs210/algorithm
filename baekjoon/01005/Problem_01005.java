import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem_01005 {

    public static void main(String[] args) throws IOException {

        // DFS Deep First Search 깊이 우선 탐색
        // BFS Breath First Search  너비 우선 탐색

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


            if (!y.contains(W)) {
                bw.append(Integer.toString(buildTimeList.get(W-1))).append("\n");
                continue;
            }

            // requiredList 필요 건물 리스트
            ArrayList<Integer> xClone = new ArrayList<>(x);
            ArrayList<Integer> yClone = new ArrayList<>(y);

            // requiredList 필요 테크 건물 리스트
            ArrayList<Integer> requiredList = new ArrayList<>();
            requiredList.add(W);
            for (int a=0; a<requiredList.size(); a++) {
                Iterator<Integer> yIterator = yClone.iterator();
                Iterator<Integer> xIterator = xClone.iterator();
                while (yIterator.hasNext()) {
                    if (Objects.equals(yIterator.next(), requiredList.get(a))) {
                        yIterator.remove();
                        int preBuild = xIterator.next();
                        if(!requiredList.contains(preBuild)){
                            requiredList.add(preBuild);
                        }
                        xIterator.remove();
                    } else {
                        xIterator.next();
                    }
                }
            }

            // baseList 기초 건물 리스트
            ArrayList<Integer> baseList = new ArrayList<>();
            for (int a = 0; a < N; a++) {
                if (!y.contains(a+1)) {
                    baseList.add(a+1);
                }
            }

            // x,y 필요 규칙 리스트
            Iterator<Integer> yIterator = y.iterator();
            Iterator<Integer> xIterator = x.iterator();
            while (yIterator.hasNext()) {
                if (!requiredList.contains(yIterator.next())) {
                    yIterator.remove();
                    xIterator.next();
                    xIterator.remove();
                } else {
                    xIterator.next();
                }
            }

            int[] actualBuildTime = new int[N];
            Arrays.fill(actualBuildTime, -1);
            for (int a = 0; a < N; a++) {
                if (baseList.contains(a + 1)) {
                    actualBuildTime[a] = buildTimeList.get(a);
                }
                if(!requiredList.contains(a+1)){
                    actualBuildTime[a] = -2;
                }
            }

            boolean stillLeft;
            do {
                stillLeft=false;
                for (int a=0; a<N; a++) {
                    if(actualBuildTime[a]==-1){
                        boolean disableToBuild = false;
                        ArrayList<Integer> temp = new ArrayList<>();
                        for(int b=0; b<y.size(); b++) {
                            if(y.get(b)==(a+1)){
                                if(actualBuildTime[x.get(b)-1]==-1){
                                    disableToBuild=true;
                                    continue;
                                }
                                temp.add(actualBuildTime[x.get(b)-1]);
                            }
                        }
                        if(disableToBuild) {
                            stillLeft = true;
                            continue;
                        }
                        actualBuildTime[a] = Collections.max(temp) + buildTimeList.get(a);
                    }
                }
            } while (stillLeft);




            bw.append(Integer.toString(actualBuildTime[W - 1])).append("\n");
            // 로직 종료
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
