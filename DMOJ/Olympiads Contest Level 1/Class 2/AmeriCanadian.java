import java.util.Scanner;

public class AmeriCanadian {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String input = scanner.nextLine();
			String inputNew = input;
			
			if (input.equals("quit!")) {
				break;
			} else if (input.length() <= 4) {
				System.out.println(input);
			} else {
				for (int i = 0; i < input.length()-2; i++) {
					String or = input.substring(i, i+3);
					if (or.equals("aor") || or.equals("eor") || or.equals("ior") || or.equals("oor") || or.equals("uor")) {
					} else {
						inputNew = input.replace("or", "our");
					}
				}
				System.out.println(inputNew);
			}
		}
	}
}