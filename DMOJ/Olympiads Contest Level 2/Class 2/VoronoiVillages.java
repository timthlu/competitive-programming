import java.util.Scanner;
import java.util.Arrays;

public class VoronoiVillages {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int villages = scanner.nextInt();
		int[] positions = new int[villages];
		for (int i = 0; i < villages; i++) {
			positions[i] = scanner.nextInt();
		}
		
		Arrays.sort(positions);
		double[] midpoints = new double[villages-1];
		for (int i = 0; i < villages-1; i++) {
			midpoints[i] = (positions[i] + positions[i+1])/2.0;
		}
		
		double minSize = Double.MAX_VALUE;
		for (int i = 1; i < villages-1; i++) {
			double villageSize = positions[i] - midpoints[i-1] + midpoints[i] - positions[i];
			if (minSize > villageSize) {
				minSize = villageSize;
			}
		}
		
		System.out.printf("%.1f", minSize);
	}
}