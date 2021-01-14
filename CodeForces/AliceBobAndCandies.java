import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AliceBobAndCandies {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int len = Integer.parseInt(br.readLine());
			int[] a = new int[len];
			
			int[] prefixSum = new int[len+1];
			int[] suffixSum = new int[len+1];
			
			String[] input = br.readLine().split(" ");
			prefixSum[0] = 0;
			for (int j = 0; j < len; j++) {
				a[j] = Integer.parseInt(input[j]);
				
				if (j == 0) {
					prefixSum[1] = a[0];
				} else {
					prefixSum[j+1] = prefixSum[j] + a[j];
				}
			}
			
			suffixSum[len-1] = a[len-1];
			for (int j = len-2; j >= 0; j--) {
				suffixSum[j] = suffixSum[j+1] + a[j];
			}
			suffixSum[len] = 0;
			
			/*
			for (int j = 0; j <= len; j++) {
				System.out.print(prefixSum[j] + " ");
			} System.out.println();
			
			for (int j = 0; j <= len; j++) {
				System.out.print(suffixSum[j] + " ");
			} System.out.println();
			*/
			
			
			if (len == 1) {
				System.out.println("1 " + a[0] + " 0");
			} else {
				int leftIndex = 1;
				int rightIndex = len-1;
				
				int aliceSum = a[0];
				int bobSum = 0;
				int bound = a[0];
				int totalTurns = 1;
				
				while (leftIndex <= rightIndex) {
					//bob
					int index = rightIndex;
					while (suffixSum[index+1] - suffixSum[rightIndex+1] <= bound && index >= leftIndex) {
						//System.out.println("bob eats " + a[index]);
						index--;
					}
					
					bobSum += suffixSum[index+1] - suffixSum[rightIndex+1];
					bound = suffixSum[index+1] - suffixSum[rightIndex+1];
					//System.out.println("bound: " + bound);
					rightIndex = index;
					totalTurns++;
					
					//alice
					if (leftIndex <= rightIndex) {
						int index2 = leftIndex;
						while (prefixSum[index2] - prefixSum[leftIndex] <= bound && index2 <= rightIndex) {
							//System.out.println("alice eats " + a[index2]);
							index2++;
						}
						
						aliceSum += prefixSum[index2] - prefixSum[leftIndex];
						bound = prefixSum[index2] - prefixSum[leftIndex];
						//System.out.println("bound: " + bound);
						leftIndex = index2;
						totalTurns++;
					}
				}
				
				System.out.println(totalTurns + " " + aliceSum + " " + bobSum);
			}
		}
	}
}