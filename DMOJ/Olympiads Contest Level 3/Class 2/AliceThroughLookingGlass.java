import java.util.Scanner;

public class AliceThroughLookingGlass {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int[] mags = new int[cases];
		int[] x = new int[cases];
		int[] y = new int[cases];
		
		int maxMag = 1;
		
		for (int i = 0; i < cases; i++) {
			int mag = scanner.nextInt();
			mags[i] = mag;
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
			
			if (mag > maxMag) {
				maxMag = 1;
			}
		}
		
		boolean[][] crystal = {{false, false, false, false, false},
							   {false, false, false, false, false},
							   {false, false, false, false, false},
							   {false, false, true, false, false},
							   {false, true, true, true, false}};
		
		if (maxMag > 1) {
			crystal = findMagCrystal(crystal, maxMag);
		}
		
		for (int i = 0; i < crystal.length; i++) {
			for (int j = 0; j < crystal.length; j++) {
				if (crystal[i][j]) {
					System.out.print("c");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < cases; i++) {
			int currentMag = mags[i];
			int currentX = x[i];
			int currentY = y[i];
			
			if (crystal[crystal.length - currentY * (int) Math.pow(5, maxMag - currentMag) - 1][currentX * (int) Math.pow(5, maxMag - currentMag)]) {
				System.out.println("crystal");
			} else {
				System.out.println("empty");
			}
		}
	}
	
	public static boolean[][] findMagCrystal(boolean[][] array, int mag) {
		boolean[][] crystal = new boolean[array.length*5][array.length*5];
		
		for (int i = 0; i < crystal.length; i++) {
			for (int j = 0; j < crystal.length; j++) {
				if (array[i/5][j/5]) {
					crystal[i][j] = true;
				} else {
					crystal[i][j] = false;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j][i]) { // row j, col i
					crystal[j*5-1][i*5+1] = true;
					crystal[j*5-1][i*5+2] = true;
					crystal[j*5-1][i*5+3] = true;
					crystal[j*5-2][i*5+2] = true;
				}
			}
		}
		
		if (crystal.length != Math.pow(5, mag)) {
			findMagCrystal(crystal, mag);
		}
		
		return crystal;
	}
}