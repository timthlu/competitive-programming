import java.util.Scanner;

public class SnowCalls {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			String str = scanner.nextLine();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (count == 3) {
					System.out.print("-");
					count++;
				}
				if (count == 7) {
					System.out.print("-");
					count++;
				}
				
				if (count == 12) {
					break;
				}
				
				if (str.substring(j, j+1).equals("-")) {
					continue;
				} else if (str.substring(j, j+1).equals("A") || str.substring(j, j+1).equals("B") || str.substring(j, j+1).equals("C")) {
					System.out.print("2");
					count++;
				} else if (str.substring(j, j+1).equals("D") || str.substring(j, j+1).equals("E") || str.substring(j, j+1).equals("F")) {
					System.out.print("3");
					count++;
				} else if (str.substring(j, j+1).equals("G") || str.substring(j, j+1).equals("H") || str.substring(j, j+1).equals("I")) {
					System.out.print("4");
					count++;
				} else if (str.substring(j, j+1).equals("J") || str.substring(j, j+1).equals("K") || str.substring(j, j+1).equals("L")) {
					System.out.print("5");
					count++;
				} else if (str.substring(j, j+1).equals("M") || str.substring(j, j+1).equals("N") || str.substring(j, j+1).equals("O")) {
					System.out.print("6");
					count++;
				} else if (str.substring(j, j+1).equals("P") || str.substring(j, j+1).equals("Q") || str.substring(j, j+1).equals("R") || str.substring(j, j+1).equals("S")) {
					System.out.print("7");
					count++;
				} else if (str.substring(j, j+1).equals("T") || str.substring(j, j+1).equals("U") || str.substring(j, j+1).equals("V")) {
					System.out.print("8");
					count++;
				} else if (str.substring(j, j+1).equals("W") || str.substring(j, j+1).equals("X") || str.substring(j, j+1).equals("Y") || str.substring(j, j+1).equals("Z")) {
					System.out.print("9");
					count++;
				} else {
					System.out.print(str.substring(j, j+1));
					count++;
				}
				
			}
			System.out.println();
		}
	}
}