import java.util.Scanner;

public class MorganString {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			String input1 = scanner.nextLine();
			String input2 = scanner.nextLine();
			
			System.out.println(createMinString(input1, input2));
		}
		
	}
	public static String createMinString(String str1, String str2) {
		String output = "";
		if (str1.length() == 0 && str2.length() != 0) {
			output = str2;
		} else if (str1.length() != 0 && str2.length() == 0) {
			output = str1;
		} else if (str1.length() == 1 && str2.length() == 1) {
			output = str1 + str2; 
		} else if (str1.substring(0, 1).compareTo(str2.substring(0, 1)) > 0) {
			//str2 precedes str1
			output = str2.substring(0, 1) + createMinString(str1, str2.substring(1));
		} else if (str2.substring(0, 1).compareTo(str1.substring(0, 1)) == 0) {
			output = str1.substring(0, 1) + createMinString(str1.substring(1), str2);
		} else {
			//str1 precedes str2
			output = str1.substring(0, 1) + createMinString(str1.substring(1), str2);
		}
		return output;
	}
}