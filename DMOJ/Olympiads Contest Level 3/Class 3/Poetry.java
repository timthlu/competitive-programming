import java.util.Scanner;

public class Poetry {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < cases; i++) {
			String[] lines = new String[4];
			String[] lastSyllable = new String[4];
			for (int j = 0; j < 4; j++) {
				lines[j] = scanner.nextLine();
				
				for (int k = lines[j].length()-1; k >= 0; k--) {
					if (lines[j].substring(k, k+1).equalsIgnoreCase("a") || lines[j].substring(k, k+1).equalsIgnoreCase("e") || lines[j].substring(k, k+1).equalsIgnoreCase("i") || lines[j].substring(k, k+1).equalsIgnoreCase("o") || lines[j].substring(k, k+1).equalsIgnoreCase("u")) {
						lastSyllable[j] = lines[j].substring(k);
						break;
					} else if (lines[j].charAt(k) == ' ') {
						lastSyllable[j] = lines[j].substring(k+1);
						break;
					}
				}
				
				if (lastSyllable[j] == null || lastSyllable[j].length() == 0) {
					lastSyllable[j] = "";
				}
			}
			
			if (lastSyllable[0].equals(lastSyllable[1]) && lastSyllable[1].equals(lastSyllable[2]) && lastSyllable[2].equals(lastSyllable[3])) {
				System.out.println("perfect");
			} else if (lastSyllable[0].equals(lastSyllable[1]) && lastSyllable[2].equals(lastSyllable[3])) {
				System.out.println("even");
			} else if (lastSyllable[0].equals(lastSyllable[2]) && lastSyllable[1].equals(lastSyllable[3])) {
				System.out.println("cross");
			} else if (lastSyllable[0].equals(lastSyllable[3]) && lastSyllable[1].equals(lastSyllable[2])) {
				System.out.println("shell");
			} else {
				System.out.println("free");
			}
		}
	}
}