import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumProduct2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numInputs = scanner.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < numInputs; i++) {
			int input = scanner.nextInt();
			list.add(input);
		}
		
		int[] array = new int[numInputs];
		int countZeros = 0;
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
			if (array[i] == 0) {
				countZeros++;
			}
		}
		
		Arrays.sort(array);
		
		int indexOverZero = findIndexOverZero(array);
		int product;
		if (indexOverZero == -1) {
			if (array.length%2 == 0) {
				product = array[0];
				for (int i = 1; i < array.length; i++) {
					product = product*array[i];
				}
			} else {
				product = array[0];
				for (int i = 1; i < array.length-1; i++) {
					product = product*array[i];
				}
			}
		} else if (array[array.length-1] == 0 && array[0] < 0) {
			product = 0;
		} else {
			product = array[indexOverZero];
			for (int i = indexOverZero+1; i < array.length; i++) {
				product = product*array[i];
			}
			
			if ((indexOverZero - countZeros)%2 == 0) {
				for (int i = 0; i < indexOverZero - countZeros; i++) {
					product = product*array[i];
				}
			} else {
				for (int i = 0; i < indexOverZero - countZeros - 1; i++) {
					product = product*array[i];
				}
			}
		}
		
		System.out.println(product);
	}
	public static int findIndexOverZero(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				return i;
			}
		}
		
		return -1;
	}
}