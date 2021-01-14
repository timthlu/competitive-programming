import java.util.LinkedList;
import java.util.ListIterator;

public class ListTester {
	public static void main(String[] args) {
		
		LinkedList<String> staff = new LinkedList<String>();
		staff.addLast("Diana"); //D
		staff.addLast("Harry"); //DH
		staff.addLast("Romeo"); //DHR
		staff.addLast("Tom"); //DHRT
		
		ListIterator<String> it = staff.listIterator(); //|DHRT
		it.next(); //D|HRT
		it.next(); //DH|RT
		it.add("Juliet"); //DHJ|RT
		it.add("Nina"); //DHJN|RT
		it.next(); //DHJNR|T
		it.remove(); //DHJN|T
		
		for (int i = 0; i < staff.size(); i++) {
			System.out.print(staff.get(i) + " ");
		}
		System.out.println();
	}
}