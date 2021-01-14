import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnArrayProblem2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		int count = 0;
		while (array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			
			int diff = array[0];
			while (diff > 0) {
				for (int i = array.length-1; i > 0; i--) {
					array[i]--;
					diff--;
					if (diff == 0) {
						break;
					}
				}
			}
			count = count + array[0];
			int[] array2 = new int[array.length-1];
			for (int i = 0; i < array2.length; i++) {
				array2[i] = array[i+1];
			}
			
			Arrays.sort(array2);
			array = array2;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		System.out.println(count);
	}
}