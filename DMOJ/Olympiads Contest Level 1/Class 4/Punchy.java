import java.util.Scanner;

public class Punchy {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int A = 0;
		int B = 0;
		
		while (true) {
			int num = scanner.nextInt();
			
			if (num == 7) {
				System.exit(0);
			} else {
				char car = scanner.next().charAt(0);
				
				if (car == 'A') {
					if (num == 1) {
						int secondNum = scanner.nextInt();
						A = secondNum;
					} else if (num == 2) {
						System.out.println(A);
					} else if (num == 3) {
						char useless = scanner.next().charAt(0);
						if (useless == 'A') {
							A = A + A;
						} else {
							A = A + B;
						}
					} else if (num == 4) {
						char useless = scanner.next().charAt(0);
						if (useless == 'A') {
							A = A*A;
						} else {
							A = A*B;
						}
					} else if (num == 5) {
						char useless = scanner.next().charAt(0);
						if (useless == 'A') {
							A = A - A;
						} else {
							A = A - B;
						}
					} else if (num == 6) {
						char useless = scanner.next().charAt(0);
						if (useless == 'A') {
							A = A/A;
						} else {
							A = A/B;
						}
					} 
				} else {
					if (num == 1) {
						int secondNum = scanner.nextInt();
						B = secondNum;
					} else if (num == 2) {
						System.out.println(B);
					} else if (num == 3) {
						char useless = scanner.next().charAt(0);
						if (useless == 'B') {
							B = B + B;
						} else {
							B = B + A;
						}
					} else if (num == 4) {
						char useless = scanner.next().charAt(0);
						if (useless == 'B') {
							B = B*B;
						} else {
							B = B*A;
						}
					} else if (num == 5) {
						char useless = scanner.next().charAt(0);
						if (useless == 'B') {
							B = B - B;
						} else {
							B = B - A;
						}
					} else if (num == 6) {
						char useless = scanner.next().charAt(0);
						if (useless == 'B') {
							B = B/B;
						} else {
							B = B/A;
						}
					}
				}
			}
		}
	}
}