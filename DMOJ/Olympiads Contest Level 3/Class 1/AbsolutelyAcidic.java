import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class AbsolutelyAcidic {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numReadings = scanner.nextInt();
		int[] readings = new int[numReadings];
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < numReadings; i++) {
			int reading = scanner.nextInt();
			readings[i] = reading;
			hs.add(reading);
		}
		
		Integer[] set = hs.toArray(new Integer[hs.size()]);
		Arrays.sort(readings);
		Arrays.sort(set);
		
		if (readings.length == set.length) {
			int maxIndex = 0;
			int minIndex = 0;
			
			for (int i = 1; i < set.length; i++) {
				if (set[maxIndex] < set[i]) {
					maxIndex = i;
				}
				if (set[minIndex] > set[i]) {
					minIndex = i;
				}
			}
			
			System.out.println(set[maxIndex] - set[minIndex]);
		} else {
			int[] freqs = new int[set.length];
			for (int i = 0; i < set.length; i++) {
				freqs[i] = getLastIndex(readings, set[i]) - getFirstIndex(readings, set[i]) + 1;
			}
			
			int maxFreqIndex = 0;
			ArrayList<Integer> firstFrequentIndices = new ArrayList<Integer>();
			for (int i = 1; i < freqs.length; i++) {
				if (freqs[maxFreqIndex] < freqs[i]) {
					maxFreqIndex = i;
				}
			}
			for (int i = maxFreqIndex+1; i < freqs.length; i++) {
				if (freqs[i] == freqs[maxFreqIndex]) {
					firstFrequentIndices.add(i);
				}
			}
			
			if (firstFrequentIndices.size() == 0) {
				int secFreqIndex = 0;
				if (maxFreqIndex == 0) {
					secFreqIndex = 1;
				}
				ArrayList<Integer> secondFrequentIndices = new ArrayList<Integer>();
				for (int i = secFreqIndex+1; i < freqs.length; i++) {
					if (i != maxFreqIndex && freqs[secFreqIndex] < freqs[i]) {
						secFreqIndex = i;
					}
				}
				for (int i = secFreqIndex+1; i < freqs.length; i++) {
					if (freqs[i] == freqs[secFreqIndex]) {
						secondFrequentIndices.add(i);
					}
				}
				
				if (secondFrequentIndices.size() == 0) {
					System.out.println(Math.abs(set[maxFreqIndex] - set[secFreqIndex]));
				} else {
					int maxDiff = Math.abs(set[maxFreqIndex] - set[secFreqIndex]);
					for (int i = 0; i < secondFrequentIndices.size(); i++) {
						int diff = Math.abs(set[maxFreqIndex] - set[secondFrequentIndices.get(i)]);
						if (maxDiff < diff) {
							maxDiff = diff;
						}
					}
					System.out.println(maxDiff);
				}
			} else if (firstFrequentIndices.size() == 1) {
				System.out.println(Math.abs(set[maxFreqIndex] - set[firstFrequentIndices.get(0)]));
			} else {
				int maxReadingIndex = firstFrequentIndices.get(0);
				int minReadingIndex = firstFrequentIndices.get(0);
				
				for (int i = 1; i < firstFrequentIndices.size(); i++) {
					if (set[maxReadingIndex] < set[firstFrequentIndices.get(i)]) {
						maxReadingIndex = i;
					}
					if (set[minReadingIndex] > set[firstFrequentIndices.get(i)]) {
						minReadingIndex = i;
					}
				}
				
				System.out.println(set[maxReadingIndex] - set[minReadingIndex]);
			}
		}
	}
	public static int getLastIndex(int[] array, int num) {
		for (int i = array.length-1; i >= 0; i--) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;
	}
	public static int getFirstIndex(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;
	}
}