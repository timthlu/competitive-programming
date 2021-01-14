import java.util.Scanner;
import java.util.ArrayList;

public class Bebiliths {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int exConvictSpeed = scanner.nextInt();
		int numBebs = scanner.nextInt();
		
		int[] bebsSpeed = new int[numBebs];
		int[] bebsVemonDistance = new int[numBebs];
		int[] bebsClawSharpness = new int[numBebs];
		
		for (int i = 0; i < numBebs; i++) {
			bebsSpeed[i] = scanner.nextInt();
			bebsVemonDistance[i] = scanner.nextInt();
			bebsClawSharpness[i] = scanner.nextInt();
		}
		
		ArrayList<Integer> dangerRankings = new ArrayList<Integer>(); 
		dangerRankings.add(0);
		
		for (int i = 1; i < numBebs; i++) {
			boolean ranked = false;
			for (int j = 0; j < dangerRankings.size(); j++) {
				if (bebsSpeed[i] == bebsSpeed[j] && bebsSpeed[i] >= exConvictSpeed) {
					if (bebsClawSharpness[i] > bebsClawSharpness[j]) {
						dangerRankings.add(j, i); 
						ranked = true;
					}
					break;
				} else if (bebsSpeed[i] == bebsSpeed[j] && bebsSpeed[i] < exConvictSpeed) {
					if (bebsVemonDistance[i] > bebsVemonDistance[j]) {
						dangerRankings.add(j, i);
						ranked = true;
					}
					break;
				} else if (bebsSpeed[i] > bebsSpeed[j]) {
					dangerRankings.add(j, i);
					ranked = true;
					break;
				}
			}
			
			if (!ranked) {
				dangerRankings.add(i);
			}
			
			for (int j = 0; j < dangerRankings.size(); j++) {
				System.out.print(dangerRankings.get(j) + " ");
			}
			System.out.println();
		}
		
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			System.out.println(dangerRankings.get(scanner.nextInt() - 1) + 1);
		}
	}
}