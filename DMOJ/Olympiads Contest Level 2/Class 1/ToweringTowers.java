import java.io.BufferedReader; //turn into buffered reader for quicker input (as tle)

public class ToweringTowers {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(System.in);
		int size = br.readInt();
		int[] array = new int[size];
		br.readLine();
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				System.out.print(0);
			} else if (i == 1) {
				System.out.print(" " + 1);
			} else {
				int indexHigher = 0;
				for (int j = i-1; j >= 0; j--) {
					if (array[j] > array[i]) {
						indexHigher = j;
						break;
					}
				}
				
				System.out.print(" " + (i - indexHigher));
			}
		}
	}
}