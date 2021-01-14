import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class BowlingForNumbers {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for (int i = 0; i < cases; i++) {
			int pins = scanner.nextInt();
			int balls = scanner.nextInt();
			int width = scanner.nextInt();
			int[] scores = new int[pins];
			
			for (int a = 0; a < pins; a++) {
				scores[a] = scanner.nextInt();
			}
			
			int[] array1 = new int[pins-width+1];
			ArrayList<Integer> last = new ArrayList<Integer>();
			for (int a = 0; a < array1.length; a++) {
				array1[a] = scores[a] + scores[a+1] + scores[a+2];
				
				if ((a+1)%width == 0) {
					int max = -1;
					for (int b = 0; b < width; b++) {
						max = Math.max(array1[a-b], max);
					}
					last.add(max);
				}
			}
			/*
			System.out.println("\n");
			for (int a = 0; a < array1.length; a++) {
				System.out.println(array1[a]);
			} System.out.println("\n");
			*/
			int num = array1.length-1;
			int max = -1;
			while ((num+1)%width != 0) {
				max = Math.max(array1[num], max);
				num--;
			}
			if (max != -1) last.add(max);
			/*
			for (int a = 0; a < last.size(); a++) {
				System.out.println(last.get(a));
			} System.out.println("\n");
			*/
			int[] array2 = new int[last.size()];
			for (int a = 0; a < last.size(); a++) {
				array2[a] = last.get(a);
			}
			Arrays.sort(array2);
			
			int sum = 0;
			for (int a = 0; a < balls; a++) {
				if (a == array2.length) break;
				
				sum += array2[array2.length-1-a];
			}
			System.out.println(sum);
		}
	}
}