import java.util.Scanner;

public class Rovarspraket {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char[] array = input.toCharArray();
		
		char constanant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		
		char vowel[] = {'a', 'a', 'e', 'e', 'e', 'i', 'i', 'i', 'i', 'o', 'o', 'o', 'o', 'o', 'u', 'u', 'u', 'u', 'u', 'u', 'u'};
		
		char nextCon[] = {'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z', 'z'};
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') {
				System.out.print(array[i]);
			} else {
				int index = -1;
				for (int j = 0; j < constanant.length; j++) {
					if (constanant[j] == array[i]) {
						index = j;
						break;
					}
				}
				System.out.print("" + constanant[index] + vowel[index] + nextCon[index]);
			}
		}
	}
}