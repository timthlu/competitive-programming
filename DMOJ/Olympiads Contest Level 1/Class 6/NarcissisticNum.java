public class NarcissisticNum {
	public static void main(String[] args) {
		
		for (int h = 1; h < 10; h++) {
			for (int t = 0; t < 10; t++) {
				for (int d = 0; d < 10; d++) {
					if (cube(h) + cube(t) + cube(d) == h*100 + t*10 + d) {
						System.out.print(h);
						System.out.print(t);
						System.out.print(d);
						System.out.println();
					}
				}
			}
		}
		
	}
	public static int cube(int num) {
		return(num*num*num);
	}
}