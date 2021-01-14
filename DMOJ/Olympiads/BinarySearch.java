public class BinarySearch {
	public static void main(String[] args) {
		
		int[] a = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int value = 19;
		
		int hi = a.length-1;
		int lo = 0;
		int mid = (hi + lo)/2;
		
		while (Math.abs(hi - lo) > 1) {
			if (a[mid] < value) {
				lo = mid;
			} else if (a[mid] > value) {
				hi = mid;
			} else {
				lo = mid;
				hi = mid;
			}
			
			mid = (hi + lo)/2;
		}
		
		if (hi == lo) {
			System.out.println("At " + lo);
		} else {
			if (value < a[lo]) {
				System.out.println("Before " + lo);
			} else if (value == a[lo]) {
				System.out.println("At " + lo);
			} else if (value < a[hi]) {
				System.out.println("Between " + lo + " and " + hi);
			} else if (value == a[hi]) {
				System.out.println("At " + hi);
			} else {
				System.out.println("After " + hi);
			}
		}
	}
}