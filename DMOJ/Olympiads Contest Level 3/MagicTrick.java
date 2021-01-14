import java.util.Scanner;
import java.util.ArrayList;

public class MagicTrick {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int n = scanner.nextInt();
			ArrayList<Integer> cards = new ArrayList<Integer>();
			for (int j = n; j >= 1; j--) {
				cards.add(j);
			}
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			boolean impossible = false;
			for (int j = 0; j < n; j++) {
				int num = scanner.nextInt();
				
				if (num >= cards.size()) {
					impossible = true;
					scanner.nextLine();
					break;
				}
				
				ans.add(cards.get(num));
				cards.remove(num);
			}
			
			if (impossible) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int x : ans) {
					System.out.print(x + " ");
				} System.out.println();
			}
		}
	}
}