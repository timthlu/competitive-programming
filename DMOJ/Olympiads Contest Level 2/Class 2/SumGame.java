import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumGame {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] swifts = null;
		int[] semas = null;
		int size = 0;
		
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				size = Integer.parseInt(br.readLine());
				swifts = new int[size];
				semas = new int[size];
			} else {
				String input = br.readLine();
				String[] temp = input.trim().split(" ");
				
				if (i == 1) {
					for (int j = 0; j < size; j++) {
						swifts[j] = Integer.parseInt(temp[j]);
					}
				} else {
					for (int j = 0; j < size; j++) {
						semas[j] = Integer.parseInt(temp[j]);
					}
				}
			}
		}
		
		if (size == 0) {
			System.out.println(0);
		} else if (size == 1) {
			if (swifts[0] == semas[0]) System.out.println(1);
			else System.out.println(0);
		} else {
			int[] sumArraySW = new int[size-1];
			int[] sumArraySE = new int[size-1];
			sumArraySW[0] = swifts[0] + swifts[1];
			for (int i = 1; i < size-1; i++) {
				sumArraySW[i] = sumArraySW[i-1] + swifts[i+1];
			}
			sumArraySE[0] = semas[0] + semas[1];
			for (int i = 1; i < size-1; i++) {
				sumArraySE[i] = sumArraySE[i-1] + semas[i+1];
			}
			
			boolean printed = false;
			for (int i = size-2; i >= 0; i--) {
				if (sumArraySW[i] == sumArraySE[i]) {
					System.out.println(i+2);
					printed = true;
					break;
				}
			}
			
			if (!printed) {
				System.out.println(0);
			}
		}
	}
}