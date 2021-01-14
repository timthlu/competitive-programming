import java.util.Scanner;
//PARTIALLY WORKS, WORKS FOR FIRST TEST CASE
public class OptimChoco {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double amount = scanner.nextInt();
		double c1 = scanner.nextInt();
		double s1 = scanner.nextInt();
		double c2 = scanner.nextInt();
		double s2 = scanner.nextInt();
		double c3 = scanner.nextInt();
		double s3 = scanner.nextInt();
		
		double totalS = 0;
		double totalC = 0;
		
		double ratio1 = s1/c1;
		double ratio2 = s2/c2;
		double ratio3 = s3/c3;
		
		double largRatio = ratio1;
		boolean rat1 = true;
		boolean rat2 = false;
		boolean rat3 = false;
		if (largRatio < ratio2) {
			largRatio = ratio2;
			rat1 = false;
			rat2 = true;
		}
		if (largRatio < ratio3) {
			largRatio = ratio3;
			rat2 = false;
			rat1 = false;
			rat3 = true;
		}
		double secRatio;
		double smalRatio;
		if (rat1) {
			if (ratio2 < ratio3) {
				secRatio = ratio3;
				smalRatio = ratio2;
			} else {
				secRatio = ratio2;
				smalRatio = ratio3;
			}
		} else if (rat2) {
			if (ratio1 < ratio3) {
				secRatio = ratio3;
				smalRatio = ratio1;
			} else {
				secRatio = ratio1;
				smalRatio = ratio3;
			}
		} else {
			if (ratio2 < ratio1) {
				secRatio = ratio1;
				smalRatio = ratio2;
			} else {
				secRatio = ratio2;
				smalRatio = ratio1;
			}
		}
		
		int amount1 = 0;
		int amount2 = 0;
		int amount3 = 0;
		
		if (largRatio == ratio1) {
			while (amount > c1) {
				amount = amount - c1;
				totalC = totalC + c1;
				totalS = totalS + s1;
				amount1++;
			}
			if (secRatio == ratio2) {
				while (amount > c2) {
					amount = amount - c2;
					totalC = totalC + c2;
					totalS = totalS + s2;
					amount2++;
				}
				while (amount > c3) {
					amount = amount - c3;
					totalC = totalC + c3;
					totalS = totalS + s3;
					amount3++;
				}
			} else {
				while (amount > c3) {
					amount = amount - c3;
					totalC = totalC + c3;
					totalS = totalS + s3;
					amount3++;
				}
				while (amount > c2) {
					amount = amount - c2;
					totalC = totalC + c2;
					totalS = totalS + s2;
					amount2++;
				}
			}
		} else if (largRatio == ratio2) {
			while (amount > c2) {
				amount = amount - c2;
				totalC = totalC + c2;
				totalS = totalS + s2;
				amount2++;
			}
			if (secRatio == ratio1) {
				while (amount > c1) {
					amount = amount - c1;
					totalC = totalC + c1;
					totalS = totalS + s1;
					amount1++;
				}
				while (amount > c3) {
					amount = amount - c3;
					totalC = totalC + c3;
					totalS = totalS + s3;
					amount3++;
				}
			} else {
				while (amount > c3) {
					amount = amount - c3;
					totalC = totalC + c3;
					totalS = totalS + s3;
					amount3++;
				}
				while (amount > c1) {
					amount = amount - c1;
					totalC = totalC + c1;
					totalS = totalS + s1;
					amount1++;
				}
			}
		} else {
			while (amount > c3) {
				amount = amount - c3;
				totalC = totalC + c3;
				totalS = totalS + s3;
				amount3++;
			}
			if (secRatio == ratio1) {
				while (amount > c1) {
					amount = amount - c1;
					totalC = totalC + c1;
					totalS = totalS + s1;
					amount1++;
				}
				while (amount > c2) {
					amount = amount - c2;
					totalC = totalC + c2;
					totalS = totalS + s2;
					amount2++;
				}
			} else {
				while (amount > c2) {
					amount = amount - c2;
					totalC = totalC + c2;
					totalS = totalS + s2;
					amount2++;
				}
				while (amount > c1) {
					amount = amount - c1;
					totalC = totalC + c1;
					totalS = totalS + s1;
					amount1++;
				}
			}
		}
		
		System.out.println(amount1 + "\n" + amount2 + "\n" + amount3 + "\n" + totalS + "\n" + totalC);
	}
}