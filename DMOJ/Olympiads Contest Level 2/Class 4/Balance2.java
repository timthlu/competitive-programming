import java.util.Scanner;
import java.util.ArrayList;

public class Balance2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String input = scanner.nextLine();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.substring(i, i+1));
		}
		
		boolean removed = true;
		while (removed) {
			removed = false;
			
			for (int i = 0; i < list.size()-1; i++) {
				String checking = list.get(i) + list.get(i+1);
				if (checking.equals("()")) {
					list.remove(i+1);
					list.remove(i);
					
					removed = true;
				}
			}
		}
		
		if (list.isEmpty() || list.size() == 2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}