import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FarewellParty {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] peopleWearingSame = new int[n];
		int[] freq = new int[n+1];
		int[] answer = new int[n];
		int counter = 1;
		for (int i = 0; i < n; i++) {
			peopleWearingSame[i] = n-Integer.parseInt(input[i]);
			freq[peopleWearingSame[i]]++; 
			
			if (peopleWearingSame[i] == 1) {
				answer[i] = counter;
				counter++;
			}
		}
		
		for (int i = 2; i <= n; i++) {
			if (freq[i] % i != 0) {
				System.out.println("Impossible");
				System.exit(0);
			} else {
				if (freq[i] != 0) {
					int counter2 = 0;
					for (int j = 0; j < n; j++) {
						if (peopleWearingSame[j] == i) {
							counter2++;
							answer[j] = counter;
							if (counter2 == i) {
								counter++;
								counter2 = 0;
							}
						}
					}
				}
			}
		}
		
		System.out.println("Possible");
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		} System.out.println();
		
	}
}