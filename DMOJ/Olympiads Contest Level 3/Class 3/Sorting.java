import java.util.Scanner;
import java.util.HashSet;

public class Sorting {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		
		boolean no = false;
		
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
			
			if (i > 0 && array[i] != 0 && array[i] < array[i-1]) {
				no = true;
			}
		}
		
		if (!no) {
			boolean firstZeroFound = false;
			HashSet<Integer> hs = new HashSet<Integer>();
			
			for (int i = 0; i < num; i++) {
				if (array[i] == 0 && !firstZeroFound) {
					firstZeroFound = true;
				} else if (array[i] != 0 && firstZeroFound) {
					hs.add(array[i]);
				} else if (array[i] == 0 && firstZeroFound) {
					if (hs.size() > 1) {
						no = true;
						break;
					}
				}
			}
		}
		
		if (!no) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}