import java.util.Scanner;

public class AngleTriangle {
	public static void EquilateralTriangle (int AngleOne, int AngleTwo, int AngleThree) {
		//System.out.println("The final angles are: " + AngleOne + ", " + AngleTwo + ", " + AngleThree);
		
		if (AngleOne == AngleTwo && AngleTwo == AngleThree) {
			System.out.println("This triangle is already equilateral");
		} else {
			int diffOne = AngleOne - 60;
			System.out.print(AngleOne + " was");
			if (diffOne > 0) {
				System.out.print(" decreased by ");
			} else if (diffOne <= 0) {
				System.out.print(" increased by ");
			}
			System.out.print(Math.abs(diffOne) + " degrees, ");
			
			int diffTwo = AngleTwo - 60;
			System.out.print(AngleTwo + " was");
			if (diffTwo > 0) {
				System.out.print(" decreased by ");
			} else if (diffTwo <= 0) {
				System.out.print(" increased by ");
			}
			System.out.print(Math.abs(diffTwo) + " degrees, ");
			
			int diffThree = AngleThree - 60;
			System.out.print(AngleThree + " was");
			if (diffThree > 0) {
				System.out.print(" decreased by ");
			} else if (diffThree <= 0) {
				System.out.print(" increased by ");
			}
			System.out.println(Math.abs(diffThree) + " degrees to make the triangle equilateral");
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int angOne, angTwo, angThree;
		angOne = scanner.nextInt();
		angTwo = scanner.nextInt();
		angThree = scanner.nextInt();
		
		int sum = angOne + angTwo + angThree;
		if (sum == 180) {
			if (angOne == angTwo && angTwo == angThree) {
				System.out.println("Equilateral");
			} else if (angOne == angTwo && angOne != angThree) {
				System.out.println("Isosceles");
			} else if (angOne == angThree && angOne != angTwo) {
				System.out.println("Isosceles");
			} else if (angTwo == angThree && angTwo != angOne) {
				System.out.println("Isosceles");
			} else if (angOne != angTwo && angOne != angThree && angTwo!= angThree) {
				System.out.println("Scalene");
			}
		} else {
			System.out.println("Error");
			int diff = sum - 180;
			System.out.print("Difference: Sum of angles is " + Math.abs(diff));
			
			int min, max;
			min = angOne;
			if (angTwo < min) {
				min = angTwo;
			}
			if (angThree < min) {
				min = angThree;
			}
				
			max = angOne;
			if (angTwo > max) {
				max = angTwo;
			}
			if (angThree > max) {
				max = angThree;
			}
			
			if (diff > 0) {
				System.out.println(" more than 180, to be subtracted from the largest angle");
				if (max == angOne) {
					max = max - diff;
					if (max == angTwo && angTwo == angThree) {
						System.out.println("Equilateral");
						EquilateralTriangle(max, angTwo, angThree);
					} else if (max == angTwo && max != angThree) {
						System.out.println("Isosceles");
						EquilateralTriangle(max, angTwo, angThree);
					} else if (max == angThree && max != angTwo) {
						System.out.println("Isosceles");
						EquilateralTriangle(max, angTwo, angThree);
					} else if (angTwo == angThree && angTwo != max) {
						System.out.println("Isosceles");
						EquilateralTriangle(max, angTwo, angThree);
					} else if (max != angTwo && max != angThree && angTwo!= angThree) {
						System.out.println("Scalene");
						EquilateralTriangle(max, angTwo, angThree);
					}
				} else if (max == angTwo) {
					max = max - diff;
					if (angOne == max && max == angThree) {
						System.out.println("Equilateral");
						EquilateralTriangle(angOne, max, angThree);
					} else if (angOne == max && angOne != angThree) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, max, angThree);
					} else if (angOne == angThree && angOne != max) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, max, angThree);
					} else if (max == angThree && max != angOne) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, max, angThree);
					} else if (angOne != max && angOne != angThree && max!= angThree) {
						System.out.println("Scalene");
						EquilateralTriangle(angOne, max, angThree);
					}
				} else {
					max = max - diff;
					if (angOne == angTwo && angTwo == max) {
						System.out.println("Equilateral");
						EquilateralTriangle(angOne, angTwo, max);
					} else if (angOne == angTwo && angOne != max) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, max);
					} else if (angOne == max && angOne != angTwo) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, max);
					} else if (angTwo == max && angTwo != angOne) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, max);
					} else if (angOne != angTwo && angOne != max && angTwo!= max) {
						System.out.println("Scalene");
						EquilateralTriangle(angOne, angTwo, max);
					}
				}
			} else {
				System.out.println(" less than 180, to be added to the smallest angle");
					if (min == angOne) {
					min = min - diff;
					if (min == angTwo && angTwo == angThree) {
						System.out.println("Equilateral");
						EquilateralTriangle(min, angTwo, angThree);
					} else if (min == angTwo && min != angThree) {
						System.out.println("Isosceles");
						EquilateralTriangle(min, angTwo, angThree);
					} else if (min == angThree && min != angTwo) {
						System.out.println("Isosceles");
						EquilateralTriangle(min, angTwo, angThree);
					} else if (angTwo == angThree && angTwo != min) {
						System.out.println("Isosceles");
						EquilateralTriangle(min, angTwo, angThree);
					} else if (min != angTwo && min != angThree && angTwo!= angThree) {
						System.out.println("Scalene");
						EquilateralTriangle(min, angTwo, angThree);
					}
				} else if (min == angTwo) {
					min = min - diff;
					if (angOne == min && min == angThree) {
						System.out.println("Equilateral");
						EquilateralTriangle(angOne, min, angThree);
					} else if (angOne == min && angOne != angThree) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, min, angThree);
					} else if (angOne == angThree && angOne != min) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, min, angThree);
					} else if (min == angThree && min != angOne) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, min, angThree);
					} else if (angOne != min && angOne != angThree && min!= angThree) {
						System.out.println("Scalene");
						EquilateralTriangle(angOne, min, angThree);
					}
				} else {
					min = min - diff;
					if (angOne == angTwo && angTwo == min) {
						System.out.println("Equilateral");
						EquilateralTriangle(angOne, angTwo, min);
					} else if (angOne == angTwo && angOne != min) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, min);
					} else if (angOne == min && angOne != angTwo) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, min);
					} else if (angTwo == min && angTwo != angOne) {
						System.out.println("Isosceles");
						EquilateralTriangle(angOne, angTwo, min);
					} else if (angOne != angTwo && angOne != min && angTwo!= min) {
						System.out.println("Scalene");
						EquilateralTriangle(angOne, angTwo, min);
					}
				}
			}
		}
	}
}