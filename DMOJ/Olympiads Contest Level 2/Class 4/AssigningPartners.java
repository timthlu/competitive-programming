import java.util.Scanner;

public class AssigningPartners {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		
		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();
		String[] array1 = input1.split(" ");
		String[] array2 = input2.split(" ");
		
		boolean good = true;
		for (int i = 0; i < num; i++) {
			if (array1[i].equals(array2[i])) {
				good = false;
			} else {
				good = checkOtherPair(array1[i], array2[i], array1, array2);
			}
			
			if (!good) {
				break;
			}
		}
		
		if (good) {
			System.out.println("good");
		} else {
			System.out.println("bad");
		}
	}
	public static boolean checkOtherPair(String name1, String name2, String[] array1, String[] array2) {
		int newIndex = -1;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i].equals(name2)) {
				newIndex = i;
				break;
			}
		}
		
		if (array2[newIndex].equals(name1)) {
			return true;
		} else {
			return false;
		}
	}
}