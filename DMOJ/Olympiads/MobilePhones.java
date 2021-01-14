import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MobilePhones {
	static int[][] bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		bit = new int[Integer.parseInt(input[1])+1][Integer.parseInt(input[1])+1];
		
		input = br.readLine().split(" ");
		while(Integer.parseInt(input[0]) != 3) {
			int num = Integer.parseInt(input[0]);
			
			if (num == 1) {
				int x = Integer.parseInt(input[1]);
				int y = Integer.parseInt(input[2]);
				int a = Integer.parseInt(input[3]);
				
				update(x, y, a);
				
			} else if (num == 2) {
				int l = Integer.parseInt(input[1]);
				int b = Integer.parseInt(input[2]);
				int r = Integer.parseInt(input[3]);
				int t = Integer.parseInt(input[4]);
				
				System.out.println(sum(l, b, r, t));
			}
			
			input = br.readLine().split(" ");
		}
	}
	
	public static void update(int x, int y, int a) {
		x++;
		y++;
		while (y < bit.length) {
			bit[x][y] += a;
			
			y += y & (-y);
		}
	}
	
	public static int sum(int l, int b, int r, int t) {
		//x from l to r inclusive
		//y from b to t inclusive
		
		l++;
		r++;
		t++;
		
		int tempB = b;
		int tempT = t;
		
		
		int finalSum = 0;
		for (int i = l; i <= r; i++) {
			int sum1 = 0;
			int sum2 = 0;
			
			while (b > 0) {
				sum1 += bit[i][b];
				
				b -= b & (-b);
			}
			
			while (t > 0) {
				sum2 += bit[i][t];
				
				t -= t & (-t);
			}
			
			finalSum += sum2 - sum1;
			
			b = tempB;
			t = tempT;
		}
		
		return finalSum;
	}
}