import java.util.Scanner;
import java.util.Arrays;

public class LilyHomework {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
		}
		
		int swaps1 = 0;
		int[] array1 = Arrays.copyOf(array, array.length);
		while (true) {
			swaps1 = swaps1 + SortOnceStoL(array1);
			boolean ale = CheckSortedStoL(array1);
			if (ale) {
				break;
			}
		}
		
		int swaps2 = 0;
		while (true) {
			swaps2 = swaps2 + SortOnceLtoS(array);
			boolean ale = CheckSortedLtoS(array);
			if (ale) {
				break;
			}
		}
		
		int opt1, opt2;
		
		if (swaps1%2 == 0) {
			opt1 = swaps1/2;
		} else {
			opt1 = (swaps1+1)/2;
		}
		
		if (swaps2%2 == 0) {
			opt2 = swaps2/2;
		} else {
			opt2 = (swaps2+1)/2;
		}
		
		if (opt1 < opt2) {
			System.out.println(opt1);
		} else {
			System.out.println(opt2);
		}
		
	}
	public static int SortOnceStoL(int[] input) {
		int count = 0;
		for (int i = 0; i < input.length-1; i++) {
			if (input[i] > input[i+1]) {
				int temp = input[i+1];
				input[i+1] = input[i];
				input[i] = temp;
				count++;
			}
		}
		return count;
	}
	public static int SortOnceLtoS(int[] input) {
		int count = 0;
		for (int i = 0; i < input.length-1; i++) {
			if (input[i] < input[i+1]) {
				int temp = input[i+1];
				input[i+1] = input[i];
				input[i] = temp;
				count++;
			}
		}
		return count;
	}
	public static boolean CheckSortedStoL(int[] input) {
		boolean boon = false;
		int count = 0;
		
		for (int i = 0; i < input.length-1; i++) {
			if (input[i] <= input[i+1]) {
				count = count + 1;
			}
		}
		
		if (count == input.length-1) {
			boon = true;
		}
		return boon;
	}
	public static boolean CheckSortedLtoS(int[] input) {
		boolean boon = false;
		int count = 0;
		
		for (int i = 0; i < input.length-1; i++) {
			if (input[i] >= input[i+1]) {
				count = count + 1;
			}
		}
		
		if (count == input.length-1) {
			boon = true;
		}
		return boon;
	}
}