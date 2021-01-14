import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheesecakeDistribution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long friends = Long.parseLong(input);
		
		long[] slices = new long[(int)friends];
		long sum = 0;
		input = br.readLine();
		String[] array = input.trim().split(" ");
		
		for (int j = 0; j < array.length; j++) {
			long num = Long.parseLong(array[j]);
			slices[j] = num;
			sum = sum + num;
		}
		
		if (sum%friends != 0) {
			System.out.println("Impossible");
		} else {
			long moves = 0;
			long avg = sum/friends;
			
			for (int i = 0; i < friends; i++) {
				moves = moves + Math.abs(slices[i] - avg);
			}
			
			System.out.println(moves/2);
		}
	}
	public static boolean checkIfEqual(long[] list) {
		for (int i = 1; i < list.length; i++) {
			if (list[i] != list[i-1]) {
				return false;
			}
		}
		
		return true;
	}
	public static int findMaxIndex(long[] list) {
		int max = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i] > list[max]) {
				max = i;
			}
		}
		
		return max;
	}
	public static int findMinIndex(long[] list) {
		int min = 0;
		for (int i = 1; i < list.length; i++) {
			if (list[i] < list[min]) {
				min = i;
			}
		}
		
		return min;
	}
}