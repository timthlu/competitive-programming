import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gates {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gates = Integer.parseInt(br.readLine());
		boolean[] taken = new boolean[gates];
		int planes = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < gates; i++) {
			taken[i] = false;
		}
		
		boolean finished = false;
		for (int i = 0; i < planes; i++) {
			int bound = Integer.parseInt(br.readLine());
			boolean landed = false;
			for (int j = bound-1; j >= 0; j--) {
				if (!taken[j]) {
					taken[j] = true;
					landed = true;
					break;
				}
			}
			
			if (!landed) {
				System.out.println(i);
				finished = true;
				break;
			}
		}
		
		if (!finished) {
			System.out.println(planes);
		}
	}
}