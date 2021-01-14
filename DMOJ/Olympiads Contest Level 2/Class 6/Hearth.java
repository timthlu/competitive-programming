import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Hearth {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int mana = scanner.nextInt();
		scanner.nextLine();
		
		String[] cardName = new String[n];
		int[] cardCost = new int[n];
		
		for (int i = 0; i < n; i++) {
			cardName[i] = scanner.next();
			cardCost[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		ArrayList<String> sols = new ArrayList<String>();
		
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				for (int k = j+1; k < n; k++) {
					if (cardCost[i] + cardCost[j] + cardCost[k] <= mana) {
						String[] sol = {cardName[i], cardName[j], cardName[k]};
						Arrays.sort(sol);
						
						sols.add(sol[0] + " " + sol[1] + " " + sol[2]);
					}
				}
			}
		}
		
		Collections.sort(sols);
		
		for (int i = 0; i < sols.size(); i++) {
			System.out.println(sols.get(i));
		}
	}
}