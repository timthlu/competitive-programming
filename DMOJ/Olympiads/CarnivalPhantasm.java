import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class CarnivalPhantasm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //number of stalls
		int s = Integer.parseInt(input[1]); //number of stalls selling candy apples
		Stall[] stalls = new Stall[n];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			stalls[i] = new Stall(Integer.parseInt(input[i]));
		}
		
		for (int i = 0; i < s; i++) {
			input = br.readLine().split(" ");
			stalls[Integer.parseInt(input[0])-1].candyApple[Integer.parseInt(input[1])] = true;
		}
		
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			input = br.readLine().split(" ");
			
			if (input[0].equals("A")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				stalls[x-1].candyApple[k] = true;
			} else if (input[0].equals("S")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				stalls[x-1].candyApple[k] = false;
			} else if (input[0].equals("E")) {
				int x = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);
				
				stalls[x-1].dis = k;
				Arrays.fill(stalls[x-1].candyApple, false);
			} else {
				int k = Integer.parseInt(input[1]);
				
				int bestStall = -1;
				int bestDis = Integer.MAX_VALUE;
				
				for (int j = 0; j < n; j++) {
					if (stalls[j].candyApple[k]) {
						if (bestDis > stalls[j].dis) {
							bestStall = j+1;
							bestDis = stalls[j].dis;
						} else if (bestDis == stalls[j].dis) {
							bestStall = Math.min(j+1, bestStall);
						}
					}
				}
				
				System.out.println(bestStall);
				
				
			}
		}
		
	}
	static class Stall {
		boolean[] candyApple = new boolean[101];
		int dis;
		long prime;
		
		public Stall (int dis) {
			this.dis = dis;
		}
	}
}