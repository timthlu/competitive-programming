import java.util.Scanner;

public class LoveGuru {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String name1 = scanner.nextLine();
		String name2 = scanner.nextLine();
		
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < name1.length(); i++) {
			for (int j = 0; j < alpha.length(); j++) {
				if (name1.substring(i, i+1).equalsIgnoreCase(alpha.substring(j, j+1))) {
					int num = j + 1;
					num = ModPower(num, i);
					count1 = count1 + num;
				}
			}
		}
		
		for (int i = 0; i < name2.length(); i++) {
			for (int j = 0; j < alpha.length(); j++) {
				if (name2.substring(i, i+1).equalsIgnoreCase(alpha.substring(j, j+1))) {
					int num = j + 1;
					num = ModPower(num, i);
					count2 = count2 + num;
				}
			}
		}
		
		if (count1 % 10 == 0 && count2 % 10 != 0) {
			System.out.println(10 + count2 % 10);
		} else if (count1 % 10 != 0 && count2 % 10 == 0) {
			System.out.println(10 + count1 % 10);
		} else if (count1 % 10 == 0 && count2 % 10 == 0) {
			System.out.println(20);
		} else {
			System.out.println(count1 % 10 + count2 % 10);
		}
	}
	
	public static int ModPower(int num, int index) {
		int firstNum = num % 10;
		num = num % 10;
		for (int i = 0; i < index; i++) {
			num = (num * firstNum) % 10;
		}
		
		return num;
	}
}