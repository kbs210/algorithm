import java.io.*;
import java.util.*;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> buildTimeList = new ArrayList<>();
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();


            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                buildTimeList.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x.add(Integer.parseInt(st.nextToken()));
                y.add(Integer.parseInt(st.nextToken()));
            }

            int W = Integer.parseInt(br.readLine());

            // 로직 시작

            // 필요 테크트리 건물 ArrayList
            ArrayList<Integer> requiredList = new ArrayList<>();
            requiredList.add(W);

            ArrayList<Integer> xClone = new ArrayList<>();
            ArrayList<Integer> yClone = new ArrayList<>();
            for(Integer xt: x){
                xClone.add((Integer) x.clone());
            }
            for(Integer yt: y){
                yClone.add((Integer) y.clone());
            }

            for (Integer integer : requiredList) {
                Iterator<Integer> yIterator = yClone.iterator();
                Iterator<Integer> xIterator = xClone.iterator();
                while (yIterator.hasNext()) {
                    if (Objects.equals(yIterator.next(), integer)) {
                        yIterator.remove();
                        requiredList.add(xIterator.next());
                        xIterator.remove();
                    } else {
                        xIterator.next();
                    }
                }
            }

            // 테크건물 목록 requiredList


            // 기초 건물, Y 없는 건물
            ArrayList<Integer> baseList = new ArrayList<>();
            for (int a = 0; a < N; a++) {
                if(!y.contains(a)){
                    baseList.add(a);
                }
            }

            for (int a=0; a<N; a++) {
                if(!baseList.contains(a)){
                    buildTimeList.set(a,-1);
                }
            }

            Iterator<Integer> yIterator = y.iterator();
            Iterator<Integer> xIterator = x.iterator();

            while (yIterator.hasNext()){
                if(!requiredList.contains(yIterator.next())){
                    yIterator.remove();
                    xIterator.next();
                    xIterator.remove();
                } else{
                    xIterator.next();
                }
            }

            for(int a=0; a<N; a++) {

            }



//            bw.append(Integer.toString(buildTime[W-1])).append("\n");
            // 로직 종료
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
