import java.util.Scanner;

public class ISpeakTxtMsg {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		String[] arrayOne = new String[12];
		arrayOne[0] = "CU";
		arrayOne[1] = ":-)";
		arrayOne[2] = ":-(";
		arrayOne[3] = ";-)";
		arrayOne[4] = ":-P";
		arrayOne[5] = "(~.~)";
		arrayOne[6] = "TA";
		arrayOne[7] = "CCC";
		arrayOne[8] = "CUZ";
		arrayOne[9] = "TY";
		arrayOne[10] = "YW";
		arrayOne[11] = "TTYL";
		
		String[] arrayTwo = new String[12];
		arrayTwo[0] = "see you";
		arrayTwo[1] = "I'm happy";
		arrayTwo[2] = "I'm unhappy";
		arrayTwo[3] = "wink";
		arrayTwo[4] = "stick out my tongue";
		arrayTwo[5] = "sleepy";
		arrayTwo[6] = "totally awesome";
		arrayTwo[7] = "Canadian Computing Competition";
		arrayTwo[8] = "because";
		arrayTwo[9] = "thank-you";
		arrayTwo[10] = "you're welcome";
		arrayTwo[11] = "talk to you later";
		
		int i;
		while (true) {
			input = scanner.nextLine();
			
			for (i = 0; i < arrayOne.length; i++) {
				if (input.equals(arrayOne[11])) {
					System.out.println(arrayTwo[11]);
					System.exit(0);
				} else if (input.equals(arrayOne[i])) {
					System.out.println(arrayTwo[i]);
					break;
				}
			}
			
			if (i == arrayOne.length) {
				System.out.println(input);
			}
		}
	}
}