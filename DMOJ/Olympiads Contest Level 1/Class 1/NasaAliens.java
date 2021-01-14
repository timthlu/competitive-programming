import java.util.Scanner;

public class NasaAliens {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int antennae = scanner.nextInt();
		int eyes = scanner.nextInt();
		boolean valid = false;
		
		if (antennae >= 3 && eyes <= 4) {
			System.out.println("TroyMartian");
			valid = true;
		}
		if (antennae <= 6 && eyes >= 2) {
			System.out.println("VladSaturnian");
			valid = true;
		}
		if (antennae <= 2 && eyes <= 3) {
			System.out.println("GraemeMercurian");
			valid = true;
		}
		
		if (!valid) {
			int optionOne = 2147483647;
			int optionTwo = 2147483647;
			int optionThree = 2147483647;
			int optionFour = 2147483647;
			int optionFive = 2147483647;
			int optionSix = 2147483647;
			int optionSeven = 2147483647;
			int optionEight = 2147483647;
			int optionNine = 2147483647;
			
			if (antennae >= 3 && eyes > 4) {
				optionOne = eyes - 4;
			}
			if (antennae < 3 && eyes <= 4) {
				optionTwo = 3 - antennae;
			}
			if (antennae < 3 && eyes > 4) {
				optionThree = 3 - antennae + eyes - 4;
			}
			if (eyes >= 2 && antennae > 6) {
				optionFour = antennae - 6;
			}
			if (antennae <= 6 && eyes < 2) {
				optionFive = 2 - eyes;
			}
			if (antennae > 6 && eyes < 2) {
				optionSix = antennae - 6 + 2 - eyes;
			}
			if (antennae <= 2 && eyes > 3) {
				optionSeven = eyes - 3;
			}
			if (antennae > 2 && eyes <= 3) {
				optionEight = antennae - 2;
			}			
			if (antennae > 2 && eyes > 3) {
				optionNine = antennae - 2 + eyes - 3;
			}
			
			int min;
			min = optionOne;
			if (optionTwo < min) {
				min = optionTwo;
			}
			if (optionThree < min) {
				min = optionThree;
			}
			if (optionFour < min) {
				min = optionFour;
			}
			if (optionFive < min) {
				min = optionFive;
			}
			if (optionSix < min) {
				min = optionSix;
			}
			if (optionSeven < min) {
				min = optionSeven;
			}
			if (optionEight < min) {
				min = optionEight;
			}
			if (optionNine < min) {
				min = optionNine;
			}
			
			System.out.println(min);
			
		}
	
	}
}