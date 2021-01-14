import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("red");
		test.add(0, "orange");
		
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
		System.out.println();
	}
}