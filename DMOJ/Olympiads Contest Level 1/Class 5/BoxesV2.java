import java.util.Scanner;

public class BoxesV2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//initialize boxes
		int n = scanner.nextInt();
		int[][] boxes = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				boxes[i][j] = scanner.nextInt();
				
				//sort box
				sortDoubleArr(boxes, i, j);
				
			}
		}
		
		//initialize objects
		int m = scanner.nextInt();
		int[][] objects = new int[m][3];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				objects[i][j] = scanner.nextInt();
				
				//sort objects
				sortDoubleArr(objects, i, j);
				
			}
		}
		
		//compare
		int count = 0;
		while (true) {
			for (int i = 0; i < n; i++) {
				int count2 = 0;
				int[] options = new int[n];
				for (int j = 0; j < 3; j++) {
					if (objects[count][j] <= boxes[i][j]) {
						count2++;
					}
					if (count2 == 3) {
						options[count] = boxes[i][0]*boxes[i][1]*boxes[i][2];
						count++;
					}
					
				}
				//bubble sort options
				bubbleSortSingleArr(options);
				
				if (options[0] <= 0) {
					System.out.println("Item does not fit.");
				} else {
					System.out.println(options[0]);
				}
				
			}
			
		}
	}
	public static void sortDoubleArr(int[][] array, int a, int b) {
		
		if (b == 1 && array[a][b] < array [a][b-1]) {
			int temp = array[a][b-1];
			array[a][b-1] = array[a][b];
			array[a][b] = temp;
		} else if (b == 2 && array[a][b] < array[a][b-1] && array[a][b] >= array[a][b-2]) {
			int temp = array[a][b-1];
			array[a][b-1] = array[a][b];
			array[a][b] = temp;
		} else if (b == 2 && array[a][b] <= array[a][b-2] && array[a][b] < array[a][b-1]) {
			int temp = array[a][b-1];
			array[a][b-1] = array[a][b];
			array[a][b] = temp;
			
			int temp2 = array[a][b-1];
			array[a][b-1] = array[a][b-2];
			array[a][b-2] = temp2;
		}
	}
	public static void bubbleSortSingleArr(int[] array) {
		
		boolean con = true;
		while (con) {
			int count = 0;
			for (int i = 0; i < array.length()-1; i++) {
				if (array[i] > array[i+1]) {
					int temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					count++;
				}
				
				if (count == 0) {
					con = false;
					break;
				}
			}
		}
	}
}