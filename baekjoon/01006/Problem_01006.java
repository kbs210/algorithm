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
        }

        br.close();
        bw.close();
    }

}
