import java.util.Scanner;

public class ExactlyElectrical {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int startingX = scanner.nextInt();
		int startingY = scanner.nextInt();
		int endX = scanner.nextInt();
		int endY = scanner.nextInt();
		int charge = scanner.nextInt();
		
		boolean possible = true;
		
		if (Math.abs(startingX - endX) + Math.abs(startingY - endY) > charge || Math.abs(Math.abs(startingX - endX) + Math.abs(startingY - endY) - charge) % 2 == 1) {
			possible = false;
		}
		
		if (possible) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}
}