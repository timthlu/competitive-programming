import java.util.Scanner;

public class RoundingToFibonacci {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int num = scanner.nextInt();
			
			if (num == 1) {
				System.out.println(1);
			} else {
				int diff = Integer.MAX_VALUE;
				int prevFib = 1;
				int fib = 2;
				
				while (true) {
					if (Math.abs(num - fib) == 0) {
						System.out.println(fib);
						break;
					} else if (Math.abs(num - fib) >= diff) {
						if (Math.abs(num - fib) <= Math.abs(num - prevFib)) {
							System.out.println(fib);
						} else {
							System.out.println(prevFib);
						}
						break;
					} else if (Math.abs(num - fib) < diff) {
						diff = Math.abs(num - fib);
					} 
					
					int temp = fib;
					fib = fib + prevFib;
					prevFib = temp;
				}
			}
		}
	}
}