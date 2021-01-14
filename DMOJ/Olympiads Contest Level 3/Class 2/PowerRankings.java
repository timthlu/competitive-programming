import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class PowerRankings {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numStudents = scanner.nextInt();
		int pps = scanner.nextInt();
		Student[] students = new Student[numStudents];
		scanner.nextLine();
		
		for (int i = 0; i < numStudents; i++) {
			students[i] = new Student(scanner.nextLine());
		}
		
		for (int i = 0; i < pps; i++) {
			for (int j = 0; j < numStudents; j++) {
				students[j].addTime(scanner.nextInt());
			}
		}
		
		StudentComparator stuComp = new StudentComparator();
		Arrays.sort(students, stuComp);
		
		for (int i = 0; i < numStudents; i++) {
			int num = i + 3;
			System.out.println(num + ". " + students[i].name);
		}
	}
}

class Student {
	String name;
	int time = 0;

	public Student(String name) {
		this.name = name;
	}
	
	public void addTime(int time) {
		this.time += time;
	}
}

class StudentComparator implements Comparator<Student> { 
	public int compare(Student a, Student b) {
		if (a.time < b.time) {
			return 1;
		}
		
		return -1;
	}
}