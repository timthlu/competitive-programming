import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnArrayProblem {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		int firstIndex = 0;
		int count = 0;
		int lastIndex = array.length-1;
		while (firstIndex < lastIndex) {
			if (array[firstIndex] <= array[lastIndex]) {
				array[lastIndex] = array[lastIndex] - array[firstIndex];
				count = count + array[firstIndex];
				firstIndex++;
				
				if (array[lastIndex] == 0) {
					lastIndex--;
				}
			} else {
				array[firstIndex] = array[firstIndex] - array[lastIndex];
				count = count + array[lastIndex];
				array[lastIndex] = 0;
				lastIndex--;
			}
		}
		
		System.out.println(count);
	}
}