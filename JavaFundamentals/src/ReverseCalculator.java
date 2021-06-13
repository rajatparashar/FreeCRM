import java.util.Scanner;

public class ReverseCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		reverseUsingWhileLoop(number);
		reverseUsingForLoop(number);
		reverseUsingDoWhileLoop(number);
	}

	static void reverseUsingWhileLoop(int num) {
		int rem = 0;
		int rev = 0;
		while (num > 0) {
			rem = num % 10;
			num = num / 10;
			rev = 10 * rev + rem;
		}
		System.out.println("Reverse using while loop is: " + rev);
	}

	static void reverseUsingForLoop(int num) {
		int rem = 0;
		int rev = 0;
		for (; num > 0;) {
			rem = num % 10;
			num = num / 10;
			rev = 10 * rev + rem;
		}
		System.out.println("Reverse using for loop is: " + rev);
	}

	static void reverseUsingDoWhileLoop(int num) {
		int rem = 0;
		int rev = 0;
		do {
			rem = num % 10;
			num = num / 10;
			rev = 10 * rev + rem;
		} while (num > 0);
		System.out.println("Reverse using do-while loop is: " + rev);
	}
}