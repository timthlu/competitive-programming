public class FactorialSum {
	public static void main(String[] args) {
		
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum = sum + factorial(i);
		}
		
		System.out.println(sum);
	}
	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		} else {
			return num*factorial(num-1);
		}
	}
}