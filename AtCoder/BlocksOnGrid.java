import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BlocksOnGrid {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int h = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]);
		
		int[][] a = new int[h][w];
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < h; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				a[i][j] = Integer.parseInt(input[j]);
				min = Math.min(min, a[i][j]);
			}
		}
		
		int count = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				count += a[i][j] - min;
			}
		}
		
		System.out.println(count);
	}
}