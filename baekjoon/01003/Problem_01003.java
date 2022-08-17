import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_01003{

	public static void main(String[] args) throws IOException {

		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		int[] inputArray = new int[T];
		
		for(int i=0; i<T; i++) {
			inputArray[i] = Integer.parseInt(bf.readLine());
		}
		
		int[][] fibonacciArray = new int[41][2];
		
		fibonacciArray[0][0] = 1;	fibonacciArray[0][1] = 0;
		fibonacciArray[1][0] = 0;	fibonacciArray[1][1] = 1;
		
		for(int i=2; i<=40; i++) {
			fibonacciArray[i][0] = fibonacciArray[i-1][0] + fibonacciArray[i-2][0];
			fibonacciArray[i][1] = fibonacciArray[i-1][1] + fibonacciArray[i-2][1];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<T; i++) {
			bw.write(fibonacciArray[inputArray[i]][0] + " " + fibonacciArray[inputArray[i]][1] + "\n");
		}
		
		bw.close();
		bf.close();
		
	}
	
}
