import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Hearth {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cards = scanner.nextInt();
		int crystals = scanner.nextInt();
		scanner.nextLine();
		
		String[] cardNames = new String[cards];
		int[] cardCosts = new int[cards];
		
		for (int i = 0; i < cards; i++) {
			cardNames[i] = scanner.next();
			cardCosts[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		ArrayList<String> allPossible = new ArrayList<String>();
		
		for (int i = 0; i < cards-2; i++) {
			for (int j = i+1; j < cards-1; j++) {
				for (int k = j+1; k < cards; k++) {
					if (cardCosts[i] + cardCosts[j] + cardCosts[k] <= crystals) {
						String[] combo = {cardNames[i], cardNames[j], cardNames[k]};
						Arrays.sort(combo);
						
						allPossible.add("");
						int currentIndex = allPossible.size()-1;
						for (int a = 0; a < 3; a++) {
							allPossible.set(currentIndex, allPossible.get(currentIndex) + combo[a] + " ");
						}
						allPossible.set(currentIndex, allPossible.get(currentIndex).trim());
					}
				}
			}
		}
		
		String[] finalC = new String[allPossible.size()];
		for (int i = 0; i < allPossible.size(); i++) {
			finalC[i] = allPossible.get(i);
		}
		
		Arrays.sort(finalC);
		for (int i = 0; i < finalC.length; i++) {
			System.out.println(finalC[i]);
		}
	}
}