import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MobilePhones2 {
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
		
		int tempY = y;
		
		while (x < bit.length) {
			y = tempY;
			while (y < bit.length) {
				bit[x][y] += a;
				
				y += y & (-y);
			}
			
			x += x & (-x);
		}
		
	}
	
	public static int sum(int l, int b, int r, int t) {
		//x from l to r inclusive
		//y from b to t inclusive
		
		r++;
		t++;
		
		int tempL = l;
		int tempB = b;
		int tempR = r;
		int tempT = t;
		
		int sum1 = 0;
		while (l > 0) {
			b = tempB;
			while (b > 0) {
				sum1 += bit[l][b];
				
				b -= b & (-b);
			}
			
			l -= l & (-l);
		}
		
		b = tempB;
		l = tempL;
		
		int sum2 = 0;
		while (r > 0) {
			t = tempT;
			while (t > 0) {
				sum2 += bit[r][t];
				
				t -= t & (-t);
			}
			
			r -= r & (-r);
		}
		
		t = tempT;
		r = tempR;
		
		int sum3 = 0;
		while (r > 0) {
			b = tempB;
			while (b > 0) {
				sum3 += bit[r][b];
				
				b -= b & (-b);
			}
			r -= r & (-r);
		}
		
		int sum4 = 0;
		while (l > 0) {
			t = tempT;
			while (t > 0) {
				sum4 += bit[l][t];
				
				t -= t & (-t);
			}
			l -= l & (-l);
		}
		
		return sum2 - sum3 - sum4 + sum1;
	}
}