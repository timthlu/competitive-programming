import java.util.Scanner;

public class GrumpyDwarf {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int bars = scanner.nextInt();
		int exchangeRate = scanner.nextInt();
		
		int totalSwords = 0;
		int swords = 0;
		while (bars > 0) {
			//convert all bars to swords
			swords += bars;
			totalSwords += bars;
			
			//trade swords into bars
			bars = swords/exchangeRate;
			swords = swords%exchangeRate;
		}
		
		System.out.println(totalSwords);
	}
}