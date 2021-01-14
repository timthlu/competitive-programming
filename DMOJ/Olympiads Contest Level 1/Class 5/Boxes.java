import java.util.Scanner;

public class Boxes {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] array = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			int l = scanner.nextInt();
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			array[i][0] = l;
			array[i][1] = w;
			array[i][2] = h;
			
			if (i == n-1) {
				int m = scanner.nextInt();
				
				for (int j = 0; j < m; j++) {
					int length = scanner.nextInt();
					int width = scanner.nextInt();
					int height = scanner.nextInt();
					boxChecker(array, n, length, width, height);
				}
			}
		}
		
	}
	public static void boxChecker(int[][] arr, int N, int L, int W, int H) {
		
		int[] opt = new int[N];
		
		for (int i = 0; i < N; i++) {
			if (L <= arr[i][0] && W <= arr[i][1] && H <= arr[i][2]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else if (L <= arr[i][0] && W <= arr[i][2] && H <= arr[i][1]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else if (L <= arr[i][1] && W <= arr[i][0] && H <= arr[i][2]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else if (L <= arr[i][1] && W <= arr[i][2] && H <= arr[i][0]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else if (L <= arr[i][2] && W <= arr[i][0] && H <= arr[i][1]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else if (L <= arr[i][2] && W <= arr[i][1] && H <= arr[i][0]) {
				opt[i] = arr[i][0]*arr[i][1]*arr[i][2];
			} else {
				opt[i] = -1;
			}
		}
		
		boolean boo = true;
		int count = 0;
		while (boo) {
			for (int i = 0; i < N-1; i++) {
				if (opt[i] > opt[i+1]) {
					int temp;
					temp = opt[i];
					opt[i] = opt[i+1];
					opt[i+1] = temp;
				}
			}
			
			count = 0;
			for (int i = 0; i < N-1; i++) {
				if (opt[i] <= opt[i+1]) {
					count++;
				}
			}
			
			if (count == N-1) {
				boo = false;
			}
		}
		
		boolean no = false;
		for (int i = 0; i < N; i++) {
			if (opt[i] == -1) {
				continue;
			} else {
				System.out.println(opt[i]);
				no = true;
				break;
			}
		}
		
		if (no == false) {
			System.out.println("Item does not fit.");
		}
	}
}