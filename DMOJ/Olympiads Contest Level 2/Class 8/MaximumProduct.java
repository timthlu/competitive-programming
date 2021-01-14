import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumProduct {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numInputs = scanner.nextInt();
		
		int product = 1;
		ArrayList<Integer> negatives = new ArrayList<Integer>();
		
		boolean allZero = true;
		boolean oneInput = false;
		boolean moved = false;
		
		for (int i = 0; i < numInputs; i++) {
			int num = scanner.nextInt();
			
			if (numInputs == 1) {
				System.out.println(num);
				System.exit(0);
			}
			
			if (num > 0) {
				product = product*num;
				allZero = false;
				moved = true;
			} else if (num < 0) {
				negatives.add(num);
				allZero = false;
			}
		}
		
		if (allZero) {
			System.out.println(0);
		} else if (negatives.size() % 2 == 0) {
			for (int i = 0; i < negatives.size(); i++) {
				product = product*negatives.get(i);
				moved = true;
			}
			
			System.out.println(product);
		} else {
			int[] negativesArray = new int[negatives.size()];
			for (int i = 0; i < negatives.size(); i++) {
				negativesArray[i] = negatives.get(i);
			}
			
			Arrays.sort(negativesArray);
			
			for (int i = 0; i < negativesArray.length-1; i++) {
				product = product*negativesArray[i];
				moved = true;
			}
			
			if (negativesArray.length == 1 && !moved) {
				System.out.println(negativesArray[0]);
			} else {
				System.out.println(product);
			}
		}
	}
}