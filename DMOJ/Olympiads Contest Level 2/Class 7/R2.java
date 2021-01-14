import java.util.Scanner;

public class R2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int mean = scanner.nextInt();
		
		System.out.println(mean*2-num);
	}
}